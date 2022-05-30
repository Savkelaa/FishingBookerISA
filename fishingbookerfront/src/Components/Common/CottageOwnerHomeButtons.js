import React from "react";
import { Link } from "react-router-dom";

export default function CottageOwnerHomeButtons(cottagesByOwner) {
  // const newTo = {
  //   pathname: "/fishingClassesByInstructor",
  //  param1: { fishingClassesByInstructor },
  // };

  // console.log("troeolo", fishingClassesByInstructor);

  return (
    <div className="col-md-4">
      <div className="p-3 py-5">
        <div className="d-flex justify-content-between align-items-center experience"></div>
        <Link to="createCottage">
          <button className="btn btn-primary profile-button" type="button">
            Add cottage
          </button>
        </Link>

        <Link
          to={{
            pathname: `/cottagesByOwner`,
            state: { cottagesByOwner },
          }}
        >
          <button className="btn btn-primary profile-button" type="button">
            Cottages
          </button>
        </Link>
          
        <Link to="changePasswordCottageOwner">
          <button className="btn btn-primary profile-button" type="button">
            Change password
          </button>
        </Link>
        <Link to="availabilityPeriod">
          <button className="btn btn-primary profile-button" type="button">
            Enter availability period
          </button>
        </Link>
        <Link to="currentReservations">
          <button className="btn btn-primary profile-button" type="button">
            Current reservations
          </button>
        </Link>
        <Link to="fishingClassReservationHistory">
          <button className="btn btn-primary profile-button" type="button">
            History of reservations
          </button>
        </Link>
        <button className="btn btn-primary profile-button" type="button">
          Create an appointment for a quick reservation
        </button>
        <button className="btn btn-primary profile-button" type="button">
          Finished reservations
        </button>
        <Link to="clientsByInstructor">
          <button className="btn btn-primary profile-button" type="button">
            My clients
          </button>
        </Link>
      </div>
    </div>
  );
}
