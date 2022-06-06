import React from "react";
import { ListGroup, Image, Navbar } from "react-bootstrap";
import "../../App.css";
import pic from "../../Assets/img/profile.jpg";
import ProfilePicture from "./ProfilePicture";
import FcForm from "./FcForm";
import Navbarr from "./Navbarr";
import Footerr from "./Footerr";
import InstructorHomeButtons from "./InstructorHomeButtons";
import ProfileLabels from "./ProfileLabels";

export default function Profile({
  logedInstructor,
  sendInstructorDeleteRequestHandler,
  fishingClassesByInstructor,
  updateInstructorHandler,
  points,
  group,
  numfishingClassesByInstructor,
  pointsByFinishedReservation,
}) {
  return (
    <div className="container rounded bg-white mt-5 mb-5">
      <div className="row">
        <ProfilePicture logedInstructor={logedInstructor}></ProfilePicture>
        <ProfileLabels
          logedInstructor={logedInstructor}
          sendInstructorDeleteRequestHandler={
            sendInstructorDeleteRequestHandler
          }
          numfishingClassesByInstructor={numfishingClassesByInstructor}
          pointsByFinishedReservation={pointsByFinishedReservation}
          points={points}
          group={group}
          updateInstructorHandler={updateInstructorHandler}
        ></ProfileLabels>
        <InstructorHomeButtons
          fishingClassesByInstructor={fishingClassesByInstructor}
        ></InstructorHomeButtons>
      </div>
    </div>
  );
}
