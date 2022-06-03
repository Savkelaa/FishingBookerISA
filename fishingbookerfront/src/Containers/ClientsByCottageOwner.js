import React, { useState, useEffect } from "react";
import Footerr from "../Components/Common/Footerr";
import Navbarr from "../Components/Common/Navbarr";
import ClientsByCottageOwner from "../Components/Common/ClientsByCottageOwner";
import userServices from "../Services/UserServices/UserServices";
import { useHistory } from "react-router-dom";
import { useLocation } from "react-router-dom";

export default function ClientsByCottageOwnerContainer() {
  const [clientsByCottageOwner, setClientsByCottageOwner] = useState([]);
  const [clientsByCottageOwnerQuick, setclientsByCottageOwnerQuick] = useState([]);

  var logedCottageOwner = JSON.parse(localStorage.getItem("CottageOwner"));
  const history = useHistory();
  const filterParams = new URLSearchParams(useLocation().search);

  const [filterText, setfilterText] = useState(
    filterParams.has("clientName")
      ? filterParams.get("clientName")
      : ""
  );

  useEffect(() => {
    userServices
      .getAllClientsByCottageOwnerCottageReservations(
        logedCottageOwner.id,
        filterText
      )
      .then((data) => {
        setClientsByCottageOwner(data.data);
      })
      .catch((error) => console.log(`error`, error));

    userServices
      .getAllClientsByCottageOwnerCottageQuickReservations(
        logedCottageOwner.id,
        filterText
      )
      .then((data) => {
        setclientsByCottageOwnerQuick(data.data);
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
      <ClientsByCottageOwner
        clientsByCottageOwner={clientsByCottageOwner}
        clientsByCottageOwnerQuick={clientsByCottageOwnerQuick}
        changeFilterClientsText={changeFilterClientsText}
      ></ClientsByCottageOwner>
      <Footerr></Footerr>
    </div>
  );
}
