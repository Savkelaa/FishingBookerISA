import React from "react";
import { Link } from "react-router-dom";

export default function PredefAdminHomeButtons() {
  return (
    <div className="col-md-4">
      <div className="p-3 py-5">
        <div className="d-flex justify-content-between align-items-center experience"></div>
        <Link to="/requests">
          <button className="btn btn-primary profile-button" type="button">
            Registration requirements
          </button>
        </Link>
        <Link to="/deleteRequests">
          <button className="btn btn-primary profile-button" type="button">
            Delete requirements
          </button>
        </Link>
        <Link to="/rateRequests">
          <button className="btn btn-primary profile-button" type="button">
            Rate requirements
          </button>
        </Link>
        <hr style={{ width: "100%", textAlign: "left", marginLeft: 0 }} />
        <Link to="/allInstructors">
          <button className="btn btn-primary profile-button" type="button">
            All instructors
          </button>
        </Link>
        <Link to="/fishingClasses">
          <button className="btn btn-primary profile-button" type="button">
            All fishingclasses
          </button>
        </Link>
        <hr style={{ width: "100%", textAlign: "left", marginLeft: 0 }} />
        <Link to="/allBoatOwners">
          <button className="btn btn-primary profile-button" type="button">
            All boat owners
          </button>
        </Link>
        <Link to="/allBoats">
          <button className="btn btn-primary profile-button" type="button">
            All boats
          </button>
        </Link>
        <hr style={{ width: "100%", textAlign: "left", marginLeft: 0 }} />
        <Link to="/allCottageOwners">
          <button className="btn btn-primary profile-button" type="button">
            All cottage owners
          </button>
        </Link>
        <Link to="/allCottages">
          <button className="btn btn-primary profile-button" type="button">
            All cottages
          </button>
        </Link>
        <hr style={{ width: "100%", textAlign: "left", marginLeft: 0 }} />
        <Link to="/createAdmin">
          <button className="btn btn-primary profile-button" type="button">
            Add new admins
          </button>
        </Link>
      </div>
    </div>
  );
}
