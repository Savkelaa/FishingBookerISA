import React from "react";
import { Link } from "react-router-dom";

export default function BoatOwnerHomeButtons(boatsByOwner) {
  // const newTo = {
  //   pathname: "/fishingClassesByInstructor",
  //  param1: { fishingClassesByInstructor },
  // };

  // console.log("troeolo", fishingClassesByInstructor);

  return (
    <div className="col-md-4">
      <div className="p-3 py-5">
        <div className="d-flex justify-content-between align-items-center experience"></div>
        <Link to="createBoat">
          <button className="btn btn-primary profile-button" type="button">
            Add boat
          </button>
        </Link>

        <Link
          to={{
            pathname: `/boatsByOwner`,
            state: { boatsByOwner },
          }}
        >
          <button className="btn btn-primary profile-button" type="button">
            Boats
          </button>
        </Link>

        <Link to="changePasswordBoatOwner">
          <button className="btn btn-primary profile-button" type="button">
            Change password
          </button>
        </Link>

        <Link to="boatCurrentReservation">
          <button className="btn btn-primary profile-button" type="button">
            Current reservations
          </button>
        </Link>
        <Link to="boatReservationHistory">
          <button className="btn btn-primary profile-button" type="button">
            History of reservations
          </button>
        </Link>

        <Link to="boatUpcomingReservation">
          <button className="btn btn-primary profile-button" type="button">
            Upcoming reservations
          </button>
        </Link>
        <Link to="calendarBoatOwner">
          <button className="btn btn-primary profile-button" type="button">
            Calendar
          </button>
        </Link>
        <Link to="clientsByBoatOwner">
          <button className="btn btn-primary profile-button" type="button">
            My clients
          </button>
        </Link>
      </div>
    </div>
  );
}
