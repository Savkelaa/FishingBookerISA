import React, { useState, useEffect } from "react";
import Footerr from "../Components/Common/Footerr";
import Navbarr from "../Components/Common/Navbarr";
import ClientsByInstructor from "../Components/Common/ClientsByInstructor";
import userServices from "../Services/UserServices/UserServices";
import { useHistory } from "react-router-dom";
import { useLocation } from "react-router-dom";

export default function ClientsByInstructorContainer() {
  const [clientsByInstructor, setClientsByInstructor] = useState([]);
  const [clientsByInstructorQuick, setclientsByInstructorQuick] = useState([]);

  var logedInstructor = JSON.parse(localStorage.getItem("Instructor"));
  const history = useHistory();
  const filterParams = new URLSearchParams(useLocation().search);

  const [filterText, setfilterText] = useState(
    filterParams.has("fishingclassName")
      ? filterParams.get("fishingclassName")
      : ""
  );

  useEffect(() => {
    userServices
      .getAllClientsByInstructorFishingClassReservations(
        logedInstructor.id,
        filterText
      )
      .then((data) => {
        setClientsByInstructor(data.data);
      })
      .catch((error) => console.log(`error`, error));

    userServices
      .getAllClientsByInstructorFishingClassQuickReservations(
        logedInstructor.id,
        filterText
      )
      .then((data) => {
        setclientsByInstructorQuick(data.data);
      })
      .catch((error) => console.log(`error`, error));
  }, [filterText]);

  let searchTimeout;

  function changeFilterClientsText(text) {
    clearTimeout(searchTimeout);
    searchTimeout = setTimeout(() => {
      setfilterText(text);
    }, 300);
  }

  return (
    <div>
      <Navbarr></Navbarr>
      <ClientsByInstructor
        clientsByInstructor={clientsByInstructor}
        clientsByInstructorQuick={clientsByInstructorQuick}
        changeFilterClientsText={changeFilterClientsText}
      ></ClientsByInstructor>
      <Footerr></Footerr>
    </div>
  );
}
