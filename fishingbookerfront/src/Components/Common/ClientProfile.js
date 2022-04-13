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
}) {
  return (
    <div className="container rounded bg-white mt-5 mb-5">
      <div className="row">
        <ClientProfilePicture
        logedClient={logedClient}
        ></ClientProfilePicture>
        <ClientProfileLabel
          logedClient={logedClient}
          sendInstructorDeleteRequestHandler={
            sendInstructorDeleteRequestHandler
          }
        ></ClientProfileLabel> 
        <ClientHomeButtons></ClientHomeButtons>
      </div>
    </div>
  );
}
