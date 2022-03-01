import React, { useState, useEffect } from "react";
import Navbarr from "../Components/Common/Navbarr";
import Footerr from "../Components/Common/Footerr";
import "../App.css";
import background from "../Assets/img/background.jpg";
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
    <div
      style={{
        backgroundImage: `url(${background})`,
        backgroundPosition: "center",
        backgroundSize: "cover",
        backgroundRepeat: "no-repeat",
      }}
    >
      <Navbarr></Navbarr>
      <FishingClassCard fishingClasses={fishingClasses}></FishingClassCard>
      <Footerr></Footerr>
    </div>
  );
}

export default FishingClassesContainer;