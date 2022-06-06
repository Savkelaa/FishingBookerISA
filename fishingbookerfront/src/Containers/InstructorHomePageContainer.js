import React, { useState, useEffect } from "react";
import Navbarr from "../Components/Common/Navbarr";
import Footerr from "../Components/Common/Footerr";
import background from "../Assets/img/background.jpg";
import Profile from "../Components/Common/Profile";
import "../Assets/css/profile.css";
import userServices from "../Services/UserServices/UserServices";
import fishingClassServices from "../Services/FishingClassServices/FishingClassServices";
import fishingClassQuickReservationServices from "../Services/FishingClassQuickReservationServices/FishingClassQuickReservationServices";

export default function InstructorHomePageContainer() {
  //const [logedInstructor, setlogedInstructor] = useState();

  // const [instructorRequest, setInstructorRequest] = useState([]);
  const [numfishingClassesByInstructor, setnumfishingClassesByInstructor] =
    useState();
  const [pointsByFinishedReservation, setPointsByFinishedReservation] =
    useState();
  //const [points, setPoints] = useState();

  const [group, setGroup] = useState({});

  console.log("numfishingClassesByInstructor", numfishingClassesByInstructor);
  console.log("pointsByFinishedReservation", pointsByFinishedReservation);

  var logedInstructor = JSON.parse(localStorage.getItem("Instructor"));

  useEffect(() => {
    var num = 0;
    fishingClassQuickReservationServices
      .getAllFishingClassReservationsByInstructor(logedInstructor.id)
      .then((data) => {
        console.log("fishingClassReservations", data.data.length);
        num = num + data.data.length;
        setnumfishingClassesByInstructor(data.data.length);
      })
      .catch((error) => console.log(`error`, error));

    fishingClassQuickReservationServices
      .getAllFishingClassQuickReservationsByInstructor(logedInstructor.id)
      .then((data) => {
        console.log("free", data);
        num = num + data.data.length;
        setnumfishingClassesByInstructor(num);
      })
      .catch((error) => console.log(`error`, error));

    userServices
      .getReservationPoints()
      .then((data) => {
        setPointsByFinishedReservation(data.data.points);

        userServices
          .getLoyaltyCategoryByPoints(num * data.data.points)
          .then((data) => {
            setGroup(data.data);

            // localStorage.setItem(
            //   "Points",
            //   JSON.stringify(num * data.data.points)
            // );

            localStorage.setItem("Category", JSON.stringify(data.data));
          })
          .catch((error) => console.log(`error`, error));
      })
      .catch((error) => console.log(`error`, error));
  }, []);

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
        numfishingClassesByInstructor={numfishingClassesByInstructor}
        pointsByFinishedReservation={pointsByFinishedReservation}
        group={group}
        logedInstructor={logedInstructor}
        sendInstructorDeleteRequestHandler={sendInstructorDeleteRequest}
        updateInstructorHandler={updateInstructor}
        //  fishingClassesByInstructor={fishingClassesByInstructor}
      ></Profile>
      <Footerr></Footerr>
    </div>
  );
}
