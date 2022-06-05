import React, { useState, useEffect } from "react";
import Footerr from "../Components/Common/Footerr";
import Navbarr from "../Components/Common/Navbarr";
import ClientsByBoatOwner from "../Components/Common/ClientsByBoatOwner";
import userServices from "../Services/UserServices/UserServices";
import { useHistory } from "react-router-dom";
import { useLocation } from "react-router-dom";

export default function ClientsByBoatOwnerContainer() {
  const [clientsByBoatOwner, setClientsByBoatOwner] = useState([]);
  const [clientsByBoatOwnerQuick, setclientsByBoatOwnerQuick] = useState([]);

  var logedBoatOwner = JSON.parse(localStorage.getItem("BoatOwner"));
  const history = useHistory();
  const filterParams = new URLSearchParams(useLocation().search);

  const [filterText, setfilterText] = useState(
    filterParams.has("clientName")
      ? filterParams.get("clientName")
      : ""
  );

  useEffect(() => {
    userServices
      .getAllClientsByBoatOwnerBoatReservations(
        logedBoatOwner.id,
        filterText
      )
      .then((data) => {
        setClientsByBoatOwner(data.data);
      })
      .catch((error) => console.log(`error`, error));

    userServices
      .getAllClientsByBoatOwnerBoatQuickReservations(
        logedBoatOwner.id,
        filterText
      )
      .then((data) => {
        setclientsByBoatOwnerQuick(data.data);
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
      <ClientsByBoatOwner
        clientsByBoatOwner={clientsByBoatOwner}
        clientsByBoatOwnerQuick={clientsByBoatOwnerQuick}
        changeFilterClientsText={changeFilterClientsText}
      ></ClientsByBoatOwner>
      <Footerr></Footerr>
    </div>
  );
}
