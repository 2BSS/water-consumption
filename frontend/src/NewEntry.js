import React, { useState } from 'react';

function NewEntry() {
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

  return (
    <div>
      <h2>Water Usage Form</h2>
      <form>
        <div className="form-group">
          <label htmlFor="bathroomHotWater">Bathroom Hot Water:</label>
          <input type="number" id="bathroomHotWater" name="bathroomHotWater" step="0.001" min="0" max="999.999" required />
        </div>
        <div className="form-group">
          <label htmlFor="bathroomColdWater">Bathroom Cold Water:</label>
          <input type="number" id="bathroomColdWater" name="bathroomColdWater" step="0.001" min="0" max="999.999" required />
        </div>
        <div className="form-group">
          <label htmlFor="kitchenHotWater">Kitchen Hot Water:</label>
          <input type="number" id="kitchenHotWater" name="kitchenHotWater" step="0.001" min="0" max="999.999" required />
        </div>
        <div className="form-group">
          <label htmlFor="kitchenColdWater">Kitchen Cold Water:</label>
          <input type="number" id="kitchenColdWater" name="kitchenColdWater" step="0.001" min="0" max="999.999" required />
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

export default NewEntry;