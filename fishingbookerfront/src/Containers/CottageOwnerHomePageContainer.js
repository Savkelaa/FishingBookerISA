import React, { useState, useEffect } from "react";
import Navbarr from "../Components/Common/Navbarr";
import Footerr from "../Components/Common/Footerr";
import background from "../Assets/img/background.jpg";
import CottageOwnerProfile from "../Components/Common/CottageOwnerProfile";
import "../Assets/css/profile.css";
import userServices from "../Services/UserServices/UserServices";
import cottageServices from "../Services/CottageServices/CottageServices";

export default function CottageOwnerHomePageContainer() {
  //const [logedCottageOwner, setlogedCottageOwner] = useState();

   const [cottageOwnerRequest, setCottageOwnerRequest] = useState([]);
   const [cottagesByOwner, setCottagesByOwner] = useState(
     []
   );

  var logedCottageOwner = JSON.parse(localStorage.getItem("CottageOwner"));

  /*
   useEffect(() => {
     cottageServices
      .getCottagesByOwner(loggedCottageOwner.id)
      .then((data) => {
        setCottagesByOwner(data.data);
        console.log("data.data", data.data);
      })
      .catch((error) => console.log(`error`, error));
   }, []);*/

  function sendCottageOwnerDeleteRequest(cottageOwner) {
    userServices
      .cottageOwnerSendDeleteRequest(cottageOwner)
      .then((data) => {
        console.log("sucessfuly sent a cottageOwner delete request");
      })
      .catch((error) => {
        console.log("Something wen't wrong try again");
      });
  }

  return (
    <div>
      <Navbarr></Navbarr>
      <CottageOwnerProfile
        logedCottageOwner={logedCottageOwner}
        sendCottageOwnerDeleteRequestHandler={sendCottageOwnerDeleteRequest}
        //  fishingClassesByCottageOwner={fishingClassesByCottageOwner}
      ></CottageOwnerProfile>
      <Footerr></Footerr>
    </div>
  );
}
