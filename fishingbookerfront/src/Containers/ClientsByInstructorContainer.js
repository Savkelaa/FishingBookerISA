import React, { useState, useEffect } from "react";
import Footerr from "../Components/Common/Footerr";
import Navbarr from "../Components/Common/Navbarr";
import ClientsByInstructor from "../Components/Common/ClientsByInstructor";
import userServices from "../Services/UserServices/UserServices";

export default function ClientsByInstructorContainer() {
  const [clientsByInstructor, setClientsByInstructor] = useState([]);
  const [clientsByInstructorQuick, setclientsByInstructorQuick] = useState([]);

  var logedInstructor = JSON.parse(localStorage.getItem("Instructor"));

  useEffect(() => {
    userServices
      .getAllClientsByInstructorFishingClassReservations(3)
      .then((data) => {
        setClientsByInstructor(data.data);
      })
      .catch((error) => console.log(`error`, error));

    userServices
      .getAllClientsByInstructorFishingClassQuickReservations(2)
      .then((data) => {
        setclientsByInstructorQuick(data.data);
      })
      .catch((error) => console.log(`error`, error));
  }, []);

  return (
    <div>
      <Navbarr></Navbarr>
      <ClientsByInstructor
        clientsByInstructor={clientsByInstructor}
        clientsByInstructorQuick={clientsByInstructorQuick}
      ></ClientsByInstructor>
      <Footerr></Footerr>
    </div>
  );
}
