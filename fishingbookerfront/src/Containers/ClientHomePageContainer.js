import React, { useState, useEffect } from "react";
import Navbarr from "../Components/Common/Navbarr";
import Footerr from "../Components/Common/Footerr";
import background from "../Assets/img/background.jpg";
import ClientProfile from "../Components/Common/ClientProfile";
import "../Assets/css/profile.css";
import userServices from "../Services/UserServices/UserServices";
import fishingClassServices from "../Services/FishingClassServices/FishingClassServices";

export default function ClientHomePage() {
  const [numFishingClass, setNumFishingClass] = useState({});
  const [numFishingClassQuick, setNumFishingClassQuick] = useState({});
  const [numBoat, setNumBoat] = useState({});
  const [numBoatQuick, setNumBoatQuick] = useState({});
  const [numCottage, setNumCottage] = useState({});
  const [numCottageQuick, setNumCottageQuick] = useState({});
  const [pointsByFinishedReservation, setPointsByFinishedReservation] =
    useState({});
  const [group, setGroup] = useState({});

  const [fishingClassesByInstructor, setfishingClassesByInstructor] = useState(
    []
  );

  var logedClient = JSON.parse(localStorage.getItem("Client"));

  console.log("numFishingClass", numFishingClass);
  console.log("numFishingClassQuick", numFishingClassQuick);
  console.log("numBoat", numBoat);
  console.log("numBoatQuick", numBoatQuick);
  console.log("numCottage", numCottage);
  console.log("numCottageQuick", numCottageQuick);
  console.log(
    "pointsByFinishedReservation",
    pointsByFinishedReservation.points
  );

  logedClient.points =
    (numFishingClass +
      numFishingClassQuick +
      numBoat +
      numBoatQuick +
      numCottage +
      numCottageQuick) *
    pointsByFinishedReservation.points;

  useEffect(() => {
    userServices
      .getNumberOfFinishedFishingClassReservations(logedClient.id)
      .then((data) => {
        setNumFishingClass(data.data);
        console.log("data.data", data.data);
      })
      .catch((error) => console.log(`error`, error));

    userServices
      .getNumberOfFinishedFishingClassQuickReservations(logedClient.id)
      .then((data) => {
        setNumFishingClassQuick(data.data);
        console.log("data.data", data.data);
      })
      .catch((error) => console.log(`error`, error));

    userServices
      .getNumberOfFinishedBoatReservations(logedClient.id)
      .then((data) => {
        setNumBoat(data.data);
        console.log("data.data", data.data);
      })
      .catch((error) => console.log(`error`, error));

    userServices
      .getNumberOfFinishedBoatQuickReservations(logedClient.id)
      .then((data) => {
        setNumBoatQuick(data.data);
        console.log("data.data", data.data);
      })
      .catch((error) => console.log(`error`, error));

    userServices
      .getNumberOfFinishedCottageReservations(logedClient.id)
      .then((data) => {
        setNumCottage(data.data);
        console.log("data.data", data.data);
      })
      .catch((error) => console.log(`error`, error));

    userServices
      .getNumberOfFinishedCottageQuickReservations(logedClient.id)
      .then((data) => {
        setNumCottageQuick(data.data);
        console.log("data.data", data.data);
      })
      .catch((error) => console.log(`error`, error));

    userServices
      .getReservationPoints()
      .then((data) => {
        setPointsByFinishedReservation(data.data);
        console.log("data.data", data.data);
      })
      .catch((error) => console.log(`error`, error));

    // userServices
    //   .getLoyaltyCategoryByPoints(logedClient.points)
    //   .then((data) => {
    //     setGroup(data.data);
    //     console.log("data.data", data.data);
    //   })
    //   .catch((error) => console.log(`error`, error));
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
        numFishingClass={numFishingClass}
        numFishingClassQuick={numFishingClassQuick}
        numBoat={numBoat}
        numBoatQuick={numBoatQuick}
        numCottage={numCottage}
        numCottageQuick={numCottageQuick}
        pointsByFinishedReservation={pointsByFinishedReservation}
        group={group}
        logedClient={logedClient}
        sendInstructorDeleteRequestHandler={sendInstructorDeleteRequest}
        fishingClassesByInstructor={fishingClassesByInstructor}
      ></ClientProfile>
      <Footerr></Footerr>
    </div>
  );
}
