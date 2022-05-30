import React, { useState, useEffect } from "react";
import { useHistory } from "react-router-dom";
import Navbarr from "../Components/Common/Navbarr";
import Footerr from "../Components/Common/Footerr";
import "../App.css";
import CottageCard from "../Components/Common/CottageCard";
import cottageServices from "../Services/CottageServices/CottageServices";
import CottagesByOwner from "../Components/Common/CottagesByOwner";
import { useLocation } from "react-router-dom";

function CottagesByOwnerContainer() {
  const [cottagesByOwner, setcottagesByOwner] = useState(
    []
  );

  const history = useHistory();
  const filterParams = new URLSearchParams(useLocation().search);

  const [filterText, setfilterText] = useState(
    filterParams.has("cottageName")
      ? filterParams.get("cottageName")
      : ""
  );

  var logedOwner = JSON.parse(localStorage.getItem("CottageOwner"));

  // useEffect(() => {
  //   cottageServices
  //     .getCottageByOwner(logedOwner.id)
  //     .then((data) => {
  //       setcottageesByOwner(data.data);
  //       console.log("data.data", data.data);
  //     })
  //     .catch((error) => console.log(`error`, error));
  // }, []);

  useEffect(() => {
    cottageServices
      .searchCottageByName(logedOwner.id, filterText)
      .then((data) => {
        setcottagesByOwner(data.data);
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
      <CottagesByOwner
        cottagesByOwner={cottagesByOwner}
        changeFilterClientsText={changeFilterClientsText}
      ></CottagesByOwner>
      <Footerr></Footerr>
    </div>
  );
}

export default CottagesByOwnerContainer;
