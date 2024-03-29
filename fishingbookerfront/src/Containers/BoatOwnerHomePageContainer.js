import React, { useState, useEffect } from "react";
import Navbarr from "../Components/Common/Navbarr";
import Footerr from "../Components/Common/Footerr";
import background from "../Assets/img/background.jpg";
import BoatOwnerProfile from "../Components/Common/BoatOwnerProfile";
import "../Assets/css/profile.css";
import userServices from "../Services/UserServices/UserServices";
import boatServices from "../Services/BoatServices/BoatServices";
import { Link, Route, Switch, useHistory, useLocation } from "react-router-dom";


export default function BoatOwnerHomePageContainer() {
  //const [logedBoatOwner, setlogedBoatOwner] = useState();

  const [boatOwnerRequest, setBoatOwnerRequest] = useState([]);
  const [boatsByOwner, setBoatsByOwner] = useState([]);

  var logedBoatOwner = JSON.parse(localStorage.getItem("BoatOwner"));

  
  const history = useHistory();

  function updateBoatOwner(boatOwner) {
    userServices
      .updateBoatOwner(boatOwner)
      .then((data) => {
        history.replace("/boatOwnerHomePage")
        alert("sucessfuly updated BoatOwner");
        
      })
      .catch((error) => {
        alert("Something wen't wrong try again");
      });
  }

  function sendBoatOwnerDeleteRequest(boatOwner) {
    userServices
      .boatOwnerSendDeleteRequest(boatOwner)
      .then((data) => {
        alert("sucessfuly sent a boatOwner delete request");
      })
      .catch((error) => {
        alert("Something wen't wrong try again");
      });
  }

  return (
    <div>
      <Navbarr></Navbarr>
      <BoatOwnerProfile
        logedBoatOwner={logedBoatOwner}
        sendBoatOwnerDeleteRequestHandler={sendBoatOwnerDeleteRequest}
        updateBoatOwnerHandler={updateBoatOwner}
      ></BoatOwnerProfile>
      <Footerr></Footerr>
    </div>
  );
}
