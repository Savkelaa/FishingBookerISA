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
  sendBoatOwnerDeleteRequestHandler,
  updateBoatOwnerHandler,
}) {
  return (
    <div className="container rounded bg-white mt-5 mb-5">
      <div className="row">
        <BoatOwnerProfilePicture
        logedBoatOwner={logedBoatOwner}
        ></BoatOwnerProfilePicture>
        <BoatOwnerProfileLabels
          logedBoatOwner={logedBoatOwner}
          sendBoatOwnerDeleteRequestHandler={
            sendBoatOwnerDeleteRequestHandler
          }
          updateBoatOwnerHandler={
            updateBoatOwnerHandler
          }
        ></BoatOwnerProfileLabels> 
        <BoatOwnerHomeButtons></BoatOwnerHomeButtons>
      </div>
    </div>
  );
}
