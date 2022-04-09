import React, { useState, useEffect } from "react";
import Navbarr from "../Components/Common/Navbarr";
import Footerr from "../Components/Common/Footerr";
import "../App.css";
import FishingClassCard from "../Components/Common/FishingClassCard";
import fishingClassServices from "../Services/FishingClassServices/FishingClassServices";
import FishingClassCardByInstructor from "../Components/Common/FishingClassCardByInstructor";

function FishingClassCardByInstructorContainer() {
  const [fishingClassesByInstructor, setfishingClassesByInstructor] = useState(
    []
  );

  var logedInstructor = JSON.parse(localStorage.getItem("Instructor"));

  useEffect(() => {
    fishingClassServices
      .getFishingClassByInstructor(logedInstructor.id)
      .then((data) => {
        setfishingClassesByInstructor(data.data);
        console.log("data.data", data.data);
      })
      .catch((error) => console.log(`error`, error));
  }, []);

  return (
    <div>
      <Navbarr></Navbarr>
      <FishingClassCardByInstructor
        fishingClassesByInstructor={fishingClassesByInstructor}
      ></FishingClassCardByInstructor>
      <Footerr></Footerr>
    </div>
  );
}

export default FishingClassCardByInstructorContainer;
