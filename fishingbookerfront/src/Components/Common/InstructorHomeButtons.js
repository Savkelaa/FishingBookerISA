import React from "react";
import { Link } from "react-router-dom";

export default function InstructorHomeButtons(fishingClassesByInstructor) {
  // const newTo = {
  //   pathname: "/fishingClassesByInstructor",
  //  param1: { fishingClassesByInstructor },
  // };

  // console.log("troeolo", fishingClassesByInstructor);

  return (
    <div className="col-md-4">
      <div className="p-3 py-5">
        <div className="d-flex justify-content-between align-items-center experience"></div>
        <Link to="createFishingClass">
          <button className="btn btn-primary profile-button" type="button">
            Add fishing classes
          </button>
        </Link>

        <Link
          to={{
            pathname: `/fishingClassByInstructor`,
            state: { fishingClassesByInstructor },
          }}
        >
          <button className="btn btn-primary profile-button" type="button">
            Fishing Classes
          </button>
        </Link>

        <Link to="changePasswordInstructor">
          <button className="btn btn-primary profile-button" type="button">
            Change password
          </button>
        </Link>
        <button className="btn btn-primary profile-button" type="button">
          History of reservations
        </button>
        <button className="btn btn-primary profile-button" type="button">
          Create an appointment for a quick reservation
        </button>
        <button className="btn btn-primary profile-button" type="button">
          Finished reservations
        </button>
        <Link to="mala">
          <button className="btn btn-primary profile-button" type="button">
            Schedule
          </button>
        </Link>
      </div>
    </div>
  );
}
