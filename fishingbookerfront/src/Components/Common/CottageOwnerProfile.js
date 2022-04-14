import React from "react";
import { ListGroup, Image, Navbar } from "react-bootstrap";
import "../../App.css";
import pic from "../../Assets/img/profile.jpg";
import CottageOwnerProfilePicture from "./CottageOwnerProfilePicture";
import FcForm from "./FcForm";
import Navbarr from "./Navbarr";
import Footerr from "./Footerr";
import CottageOwnerProfileLabels from "./CottageOwnerProfileLabels";
import CottageOwnerHomeButtons from "./CottageOwnerHomeButtons";

export default function CottageOwnerProfile({
  logedCottageOwner,
  sendInstructorDeleteRequestHandler,
  fishingClassesByInstructor,
}) {
  return (
    <div className="container rounded bg-white mt-5 mb-5">
      <div className="row">
        <CottageOwnerProfilePicture
        logedCottageOwner={logedCottageOwner}
        ></CottageOwnerProfilePicture>
        <CottageOwnerProfileLabels
          logedCottageOwner={logedCottageOwner}
          sendInstructorDeleteRequestHandler={
            sendInstructorDeleteRequestHandler
          }
        ></CottageOwnerProfileLabels> 
        <CottageOwnerHomeButtons></CottageOwnerHomeButtons>
      </div>
    </div>
  );
}
