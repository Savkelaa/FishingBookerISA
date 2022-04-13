import React, { useState, useEffect } from "react";
import Navbarr from "../Components/Common/Navbarr";
import Footerr from "../Components/Common/Footerr";
import background from "../Assets/img/background.jpg";
import ClientProfile from "../Components/Common/ClientProfile";
import "../Assets/css/profile.css";
import userServices from "../Services/UserServices/UserServices";
import fishingClassServices from "../Services/FishingClassServices/FishingClassServices";

export default function ClientHomePage() {
  //const [logedInstructor, setlogedInstructor] = useState();

  // const [instructorRequest, setInstructorRequest] = useState([]);
  const [fishingClassesByInstructor, setfishingClassesByInstructor] = useState(
    []
  );

  var logedClient = JSON.parse(localStorage.getItem("Client"));

  useEffect(() => {
    fishingClassServices
      .getFishingClassByInstructor(2)
      .then((data) => {
        setfishingClassesByInstructor(data.data);
        console.log("data.data", data.data);
      })
      .catch((error) => console.log(`error`, error));
  }, []);

  function sendInstructorDeleteRequest(instructor) {
    userServices
      .instructorSendDeleteRequest(instructor)
      .then((data) => {
        console.log("sucessfuly sent a instructor delete request");
      })
      .catch((error) => {
        console.log("Something wen't wrong try again");
      });
  }

  return (
    <div>
      <Navbarr></Navbarr>
      <ClientProfile
        logedClient={logedClient}
        sendInstructorDeleteRequestHandler={sendInstructorDeleteRequest}
        fishingClassesByInstructor={fishingClassesByInstructor}
      ></ClientProfile>
      <Footerr></Footerr>
    </div>
  );
}
