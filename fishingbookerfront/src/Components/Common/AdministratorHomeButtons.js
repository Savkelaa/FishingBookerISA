import React from "react";
import { Link } from "react-router-dom";

export default function AdministratorHomeButtons() {
  return (
    <div className="col-md-4">
      <div className="p-3 py-5">
        <div className="d-flex justify-content-between align-items-center experience"></div>
        <Link to="/requests">
          <button className="btn btn-primary profile-button" type="button">
            Registration requirements
          </button>
        </Link>
        <Link to="/rateRequests">
          <button className="btn btn-primary profile-button" type="button">
            Rate requirements
          </button>
        </Link>
        <button className="btn btn-primary profile-button" type="button">
          All entities
        </button>
      </div>
    </div>
  );
}
