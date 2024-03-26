import React, { useState } from 'react';

function NewMeasurement() {
  // Get current year and month
  const currentYear = new Date().getFullYear();
  const currentMonth = new Date().getMonth() + 1; // Months are zero-indexed

  // Initialize state for year and month
  const [year, setYear] = useState(currentYear);
  const [month, setMonth] = useState(currentMonth);

  // Generate options for the year dropdown list
  const yearOptions = [];
  for (let year = 1970; year <= currentYear; year++) {
    yearOptions.push(<option key={year} value={year}>{year}</option>);
  }

  // Generate options for the month dropdown list
  const months = ['January', 'February', 'March', 'April', 'May', 'June', 'July', 'August', 'September', 'October', 'November', 'December'];

  const handleSubmit = (e) => {
    e.preventDefault();

    // Format date as "yyyy-mm-01"
    const formattedDate = `${year}-${month.toString().padStart(2, '0')}-01`;

    // Create payload
    const payload = {
      userId: 18,
      date: formattedDate,
      kitchenHot: parseFloat(e.target.kitchenHotWater.value),
      kitchenCold: parseFloat(e.target.kitchenColdWater.value),
      bathroomHot: parseFloat(e.target.bathroomHotWater.value),
      bathroomCold: parseFloat(e.target.bathroomColdWater.value)
    };
    // Send data to server
    fetch('http://localhost:8080/new-measurement', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(payload)
    })
    .then(response => {
      if (!response.ok) {
        throw new Error('Network response was not ok');
      }
      return response.json();
    })
    .then(data => {
      // Handle success response
      console.log('Success:', data);
    })
    .catch(error => {
      // Handle error
      console.error('Error:', error);
    });
  };

  return (
    <div>
      <h2>Water Usage Form</h2>
      <form onSubmit={handleSubmit}>
        <div className="form-group">
          <label htmlFor="bathroomHotWater">Bathroom Hot Water:</label>
          <input type="number" id="bathroomHotWater" name="bathroomHotWater" step="0.001" min="0" max="9999999999999.999" required />
        </div>
        <div className="form-group">
          <label htmlFor="bathroomColdWater">Bathroom Cold Water:</label>
          <input type="number" id="bathroomColdWater" name="bathroomColdWater" step="0.001" min="0" max="9999999999999.999" required />
        </div>
        <div className="form-group">
          <label htmlFor="kitchenHotWater">Kitchen Hot Water:</label>
          <input type="number" id="kitchenHotWater" name="kitchenHotWater" step="0.001" min="0" max="9999999999999.999" required />
        </div>
        <div className="form-group">
          <label htmlFor="kitchenColdWater">Kitchen Cold Water:</label>
          <input type="number" id="kitchenColdWater" name="kitchenColdWater" step="0.001" min="0" max="9999999999999.999" required />
        </div>
        <div className="form-group">
          <label htmlFor="year">Year:</label>
          <select id="year" name="year" value={year} onChange={(e) => setYear(e.target.value)}>
            {yearOptions}
          </select>
        </div>
        <div className="form-group">
          <label htmlFor="month">Month:</label>
          <select id="month" name="month" value={month} onChange={(e) => setMonth(e.target.value)}>
            {months.map((month, index) => (
              <option key={index + 1} value={index + 1}>{month}</option>
            ))}
          </select>
        </div>
        <div className="form-group">
          <button type="submit">Submit</button>
        </div>
      </form>
    </div>
  );
}

export default NewMeasurement;