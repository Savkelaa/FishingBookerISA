import React from "react";

export default function AdministratorHomeButtons() {
  return (
    <div className="col-md-4">
      <div className="p-3 py-5">
        <div className="d-flex justify-content-between align-items-center experience"></div>
        <button className="btn btn-primary profile-button" type="button">
          Registration requirements
        </button>
        <button className="btn btn-primary profile-button" type="button">
          All entities
        </button>
      </div>
    </div>
  );
}
