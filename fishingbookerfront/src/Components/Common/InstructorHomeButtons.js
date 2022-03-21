import React from "react";

export default function InstructorHomeButtons() {
  return (
    <div className="col-md-4">
      <div className="p-3 py-5">
        <div className="d-flex justify-content-between align-items-center experience"></div>
        <button className="btn btn-primary profile-button" type="button">
          Fishing Classes
        </button>
        <button className="btn btn-primary profile-button" type="button">
          History of reservations
        </button>
        <button className="btn btn-primary profile-button" type="button">
          Create an appointment for a quick reservation
        </button>
        <button className="btn btn-primary profile-button" type="button">
          Finished reservations
        </button>
        <button className="btn btn-primary profile-button" type="button">
          Create new reservation
        </button>
      </div>
    </div>
  );
}
