import React, { useState, useEffect } from "react";
import { useHistory } from "react-router-dom";
import Navbarr from "../Components/Common/Navbarr";
import Footerr from "../Components/Common/Footerr";
import "../App.css";
import BoatCard from "../Components/Common/BoatCard";
import boatServices from "../Services/BoatServices/BoatServices";
import BoatsByOwner from "../Components/Common/BoatsByOwner";
import { useLocation } from "react-router-dom";

function BoatsByOwnerContainer() {
  const [boatsByOwner, setboatsByOwner] = useState(
    []
  );

  const history = useHistory();
  const filterParams = new URLSearchParams(useLocation().search);

  const [filterText, setfilterText] = useState(
    filterParams.has("boatName")
      ? filterParams.get("boatName")
      : ""
  );

  var logedOwner = JSON.parse(localStorage.getItem("BoatOwner"));

  // useEffect(() => {
  //   boatServices
  //     .getBoatByOwner(logedOwner.id)
  //     .then((data) => {
  //       setboatesByOwner(data.data);
  //       console.log("data.data", data.data);
  //     })
  //     .catch((error) => console.log(`error`, error));
  // }, []);

  useEffect(() => {
    boatServices
      .searchBoatByName(logedOwner.id, filterText)
      .then((data) => {
        setboatsByOwner(data.data);
        console.log("data.data", data.data);
      })
      .catch((error) => alert(`error`, error));
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
      <BoatsByOwner
        boatsByOwner={boatsByOwner}
        changeFilterClientsText={changeFilterClientsText}
      ></BoatsByOwner>
      <Footerr></Footerr>
    </div>
  );
}

export default BoatsByOwnerContainer;
