import React, { useState, useEffect } from "react";
import Navbarr from "../Components/Common/Navbarr";
import Footerr from "../Components/Common/Footerr";
import "../App.css";
import FishingClassCard from "../Components/Common/FishingClassCard";
import fishingClassServices from "../Services/FishingClassServices/FishingClassServices";

function FishingClassesContainer() {
  const [fishingClasses, setFishingClasses] = useState([]);

  useEffect(() => {
    fishingClassServices
      .getAllFishingClass()
      .then((data) => {
        setFishingClasses(data.data);
      })
      .catch((error) => console.log(`error`, error));
  }, []);

  return (
    <div>
      <Navbarr></Navbarr>
      <FishingClassCard fishingClasses={fishingClasses}></FishingClassCard>
      <Footerr></Footerr>
    </div>
  );
}

export default FishingClassesContainer;
