import React from "react";
import { Link } from "react-router-dom";

export default function BoatOwnerHomeButtons() {
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
          Create an appointment for a quick reservation
        </button>
        <button className="btn btn-primary profile-button" type="button">
          Finished reservations
        </button>
      </div>
    </div>
  );
}
