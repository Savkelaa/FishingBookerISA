import React, { useState, useEffect } from "react";
import Navbarr from "../Components/Common/Navbarr";
import Footerr from "../Components/Common/Footerr";
import "../App.css";
import FishingClassCard from "../Components/Common/FishingClassCard";
import boatServices from "../Services/BoatServices/BoatServices";
import CottageCard from "../Components/Common/CottageCard";
import cottageServices from "../Services/CottageServices/CottageServices";

function AllCottagesContainer() {
  const [cottages, setCottages] = useState([]);

  useEffect(() => {
    cottageServices
      .getAllCottages()

      .then((data) => {
        setCottages(data.data);
      })
      .catch((error) => console.log(`error`, error));
  }, []);

  return (
    <div>
      <Navbarr></Navbarr>
      <CottageCard cottages={cottages}></CottageCard>
      <Footerr></Footerr>
    </div>
  );
}

export default AllCottagesContainer;
