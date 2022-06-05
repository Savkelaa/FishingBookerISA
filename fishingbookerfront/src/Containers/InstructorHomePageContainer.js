import React, { useState, useEffect } from "react";
import Navbarr from "../Components/Common/Navbarr";
import Footerr from "../Components/Common/Footerr";
import background from "../Assets/img/background.jpg";
import Profile from "../Components/Common/Profile";
import "../Assets/css/profile.css";
import userServices from "../Services/UserServices/UserServices";
import fishingClassServices from "../Services/FishingClassServices/FishingClassServices";

export default function InstructorHomePageContainer() {
  //const [logedInstructor, setlogedInstructor] = useState();

  // const [instructorRequest, setInstructorRequest] = useState([]);
  // const [fishingClassesByInstructor, setfishingClassesByInstructor] = useState(
  //   []
  // );

  var logedInstructor = JSON.parse(localStorage.getItem("Instructor"));

  // useEffect(() => {
  //   fishingClassServices
  //     .getFishingClassByInstructor(2)
  //     .then((data) => {
  //       setfishingClassesByInstructor(data.data);
  //       console.log("data.data", data.data);
  //     })
  //     .catch((error) => console.log(`error`, error));
  // }, []);

  function sendInstructorDeleteRequest(instructor) {
    userServices
      .instructorSendDeleteRequest(instructor)
      .then((data) => {
        console.log("sucessfuly sent a instructor delete request");
        alert("sucessfuly sent a instructor delete request");
      })
      .catch((error) => {
        alert("Something wen't wrong try again");
      });
  }

  function updateInstructor(instructor) {
    userServices
      .updateInstructor(instructor)
      .then((data) => {
        console.log("sucessfuly updated Instructor");
        alert("sucessfuly updated Instructor");
      })
      .catch((error) => {
        alert("Something wen't wrong try again");
      });
  }

  return (
    <div>
      <Navbarr></Navbarr>
      <Profile
        logedInstructor={logedInstructor}
        sendInstructorDeleteRequestHandler={sendInstructorDeleteRequest}
        updateInstructorHandler={updateInstructor}
        //  fishingClassesByInstructor={fishingClassesByInstructor}
      ></Profile>
      <Footerr></Footerr>
    </div>
  );
}
