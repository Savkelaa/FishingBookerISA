import React from "react";
import { ListGroup, Image, Navbar } from "react-bootstrap";
import "../../App.css";
import pic from "../../Assets/img/profile.jpg";
import ClientProfilePicture from "./ClientProfilePicture";
import FcForm from "./FcForm";
import Navbarr from "./Navbarr";
import Footerr from "./Footerr";
import InstructorHomeButtons from "./InstructorHomeButtons";
import ProfileLabels from "./ProfileLabels";
import ClientProfileLabel from "./ClientProfileLabel";
import ClientHomeButtons from "./ClientHomeButtons";

export default function Profile({
  logedClient,
  sendInstructorDeleteRequestHandler,
  fishingClassesByInstructor,
  numFishingClass,
  numFishingClassQuick,
  numBoat,
  numBoatQuick,
  numCottage,
  numCottageQuick,
  pointsByFinishedReservation,
  group,
}) {
  console.log("group", group);
  // console.log("numFishingClass", numFishingClass);
  // console.log("numFishingClassQuick", numFishingClassQuick);
  // console.log("numBoat", numBoat);
  // console.log("numBoatQuick", numBoatQuick);
  // console.log("numCottage", numCottage);
  // console.log("numCottageQuick", numCottageQuick);
  // console.log(
  //   "pointsByFinishedReservation",
  //   pointsByFinishedReservation.points
  // );

  // logedClient.points =
  //   (numFishingClass +
  //     numFishingClassQuick +
  //     numBoat +
  //     numBoatQuick +
  //     numCottage +
  //     numCottageQuick) *
  //   pointsByFinishedReservation.points;

  // console.log("logedClient.points", logedClient.points);

  // localStorage.setItem("Client", JSON.stringify(logedClient));

  return (
    <div className="container rounded bg-white mt-5 mb-5">
      <div className="row">
        <ClientProfilePicture logedClient={logedClient}></ClientProfilePicture>
        <ClientProfileLabel
          logedClient={logedClient}
          sendInstructorDeleteRequestHandler={
            sendInstructorDeleteRequestHandler
          }
          numFishingClass={numFishingClass}
          numFishingClassQuick={numFishingClassQuick}
          numBoat={numBoat}
          numBoatQuick={numBoatQuick}
          numCottage={numCottage}
          numCottageQuick={numCottageQuick}
        ></ClientProfileLabel>
        <ClientHomeButtons></ClientHomeButtons>
      </div>
    </div>
  );
}
