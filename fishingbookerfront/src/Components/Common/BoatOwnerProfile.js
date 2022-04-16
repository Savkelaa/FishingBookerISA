import React from "react";
import { ListGroup, Image, Navbar } from "react-bootstrap";
import "../../App.css";
import pic from "../../Assets/img/profile.jpg";
import BoatOwnerProfilePicture from "./BoatOwnerProfilePicture";
import FcForm from "./FcForm";
import Navbarr from "./Navbarr";
import Footerr from "./Footerr";
import BoatOwnerProfileLabels from "./BoatOwnerProfileLabels";
import BoatOwnerHomeButtons from "./BoatOwnerHomeButtons";

export default function BoatOwnerProfile({
  logedBoatOwner,
  sendInstructorDeleteRequestHandler,
  fishingClassesByInstructor,
}) {
  return (
    <div className="container rounded bg-white mt-5 mb-5">
      <div className="row">
        <BoatOwnerProfilePicture
        logedBoatOwner={logedBoatOwner}
        ></BoatOwnerProfilePicture>
        <BoatOwnerProfileLabels
          logedBoatOwner={logedBoatOwner}
          sendInstructorDeleteRequestHandler={
            sendInstructorDeleteRequestHandler
          }
        ></BoatOwnerProfileLabels> 
        <BoatOwnerHomeButtons></BoatOwnerHomeButtons>
      </div>
    </div>
  );
}
