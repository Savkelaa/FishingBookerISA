import React, { useState, useEffect } from "react";
import { useHistory } from "react-router-dom";
import Navbarr from "../Components/Common/Navbarr";
import Footerr from "../Components/Common/Footerr";
import "../App.css";
import FishingClassCard from "../Components/Common/FishingClassCard";
import fishingClassServices from "../Services/FishingClassServices/FishingClassServices";
import FishingClassCardByInstructor from "../Components/Common/FishingClassCardByInstructor";
import { useLocation } from "react-router-dom";

function FishingClassCardByInstructorContainer() {
  const [fishingClassesByInstructor, setfishingClassesByInstructor] = useState(
    []
  );

  const history = useHistory();
  const filterParams = new URLSearchParams(useLocation().search);

  const [filterText, setfilterText] = useState(
    filterParams.has("fishingclassName")
      ? filterParams.get("fishingclassName")
      : ""
  );

  var logedInstructor = JSON.parse(localStorage.getItem("Instructor"));

  // useEffect(() => {
  //   fishingClassServices
  //     .getFishingClassByInstructor(logedInstructor.id)
  //     .then((data) => {
  //       setfishingClassesByInstructor(data.data);
  //       console.log("data.data", data.data);
  //     })
  //     .catch((error) => console.log(`error`, error));
  // }, []);

  useEffect(() => {
    fishingClassServices
      .searchFishingClassByName(logedInstructor.id, filterText)
      .then((data) => {
        setfishingClassesByInstructor(data.data);
        console.log("data.data", data.data);
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
      <FishingClassCardByInstructor
        fishingClassesByInstructor={fishingClassesByInstructor}
        changeFilterClientsText={changeFilterClientsText}
      ></FishingClassCardByInstructor>
      <Footerr></Footerr>
    </div>
  );
}

export default FishingClassCardByInstructorContainer;
