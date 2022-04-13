import React from "react";
import { Link } from "react-router-dom";

export default function ClientHomeButtons() {
  // const newTo = {
  //   pathname: "/fishingClassesByInstructor",
  //  param1: { fishingClassesByInstructor },
  // };

  // console.log("troeolo", fishingClassesByInstructor);

  return (
    <div className="col-md-4">
      <div className="p-3 py-5">
        <div className="d-flex justify-content-between align-items-center experience"></div>
        <button className="btn btn-primary profile-button" type="button">
          History of reservations
        </button>
        <button className="btn btn-primary profile-button" type="button">
          Create reservation
        </button>
        <button className="btn btn-primary profile-button" type="button">
          Create quick reservation
        </button>
        <button className="btn btn-primary profile-button" type="button">
          Cancel reservation
        </button>
        <button className="btn btn-primary profile-button" type="button">
          Make a complaint
        </button>
      </div>
    </div>
  );
}
