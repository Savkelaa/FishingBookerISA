import React, { useState, useEffect } from "react";
import Navbarr from "../Components/Common/Navbarr";
import Footerr from "../Components/Common/Footerr";
import background from "../Assets/img/background.jpg";
import BoatOwnerProfile from "../Components/Common/BoatOwnerProfile";
import "../Assets/css/profile.css";
import userServices from "../Services/UserServices/UserServices";
import boatServices from "../Services/BoatServices/BoatServices";

export default function BoatOwnerHomePageContainer() {
  //const [logedBoatOwner, setlogedBoatOwner] = useState();

   const [boatOwnerRequest, setBoatOwnerRequest] = useState([]);
   const [boatsByOwner, setBoatsByOwner] = useState(
     []
   );

  var logedBoatOwner = JSON.parse(localStorage.getItem("BoatOwner"));

  /*
   useEffect(() => {
     boatServices
      .getBoatsByOwner(loggedBoatOwner.id)
      .then((data) => {
        setBoatsByOwner(data.data);
        console.log("data.data", data.data);
      })
      .catch((error) => console.log(`error`, error));
   }, []);*/

  function sendBoatOwnerDeleteRequest(boatOwner) {
    userServices
      .boatOwnerSendDeleteRequest(boatOwner)
      .then((data) => {
        console.log("sucessfuly sent a boatOwner delete request");
      })
      .catch((error) => {
        console.log("Something wen't wrong try again");
      });
  }

  return (
    <div>
      <Navbarr></Navbarr>
      <BoatOwnerProfile
        logedBoatOwner={logedBoatOwner}
        sendBoatOwnerDeleteRequestHandler={sendBoatOwnerDeleteRequest}
        //  fishingClassesByBoatOwner={fishingClassesByBoatOwner}
      ></BoatOwnerProfile>
      <Footerr></Footerr>
    </div>
  );
}
