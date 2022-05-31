import React, { useState, useEffect } from "react";
import Navbarr from "../Components/Common/Navbarr";
import Footerr from "../Components/Common/Footerr";
import background from "../Assets/img/background.jpg";
import CottageOwnerProfile from "../Components/Common/CottageOwnerProfile";
import "../Assets/css/profile.css";
import userServices from "../Services/UserServices/UserServices";
import cottageServices from "../Services/CottageServices/CottageServices";
import { Link, Route, Switch, useHistory, useLocation } from "react-router-dom";


export default function CottageOwnerHomePageContainer() {
  //const [logedCottageOwner, setlogedCottageOwner] = useState();

   const [cottageOwnerRequest, setCottageOwnerRequest] = useState([]);
   const [cottagesByOwner, setCottagesByOwner] = useState(
     []
   );

  var logedCottageOwner = JSON.parse(localStorage.getItem("CottageOwner"));

  
  const history = useHistory();

  function updateCottageOwner(cottageOwner) {
    userServices
      .updateCottageOwner(cottageOwner)
      .then((data) => {
        history.replace("/cottageOwnerHomePage")
        alert("sucessfuly updated CottageOwner");
        
      })
      .catch((error) => {
        alert("Something wen't wrong try again");
      });
  }

  function sendCottageOwnerDeleteRequest(cottageOwner) {
    userServices
      .cottageOwnerSendDeleteRequest(cottageOwner)
      .then((data) => {
        alert("sucessfuly sent a cottageOwner delete request");
      })
      .catch((error) => {
        alert("Something wen't wrong try again");
      });
  }

  return (
    <div>
      <Navbarr></Navbarr>
      <CottageOwnerProfile
        logedCottageOwner={logedCottageOwner}
        sendCottageOwnerDeleteRequestHandler={sendCottageOwnerDeleteRequest}
        updateCottageOwnerHandler={updateCottageOwner}
      ></CottageOwnerProfile>
      <Footerr></Footerr>
    </div>
  );
}
