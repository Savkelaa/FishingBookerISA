import React, { useState, useEffect } from "react";
import Navbarr from "../Components/Common/Navbarr";
import Footerr from "../Components/Common/Footerr";
import "../App.css";
import FishingClassCard from "../Components/Common/FishingClassCard";
import boatServices from "../Services/BoatServices/BoatServices";
import BoatCard from "../Components/Common/BoatCard";
import NavbarAdmin from "../Components/Common/NavbarAdmin";

function AllBoatsContainer() {
  const [boats, setBoats] = useState([]);

  useEffect(() => {
    boatServices
      .getAllBoats()

      .then((data) => {
        setBoats(data.data);
      })
      .catch((error) => console.log(`error`, error));
  }, []);

  return (
    <div>
      {" "}
      <NavbarAdmin></NavbarAdmin>
      <BoatCard boats={boats}></BoatCard>
      <Footerr></Footerr>
    </div>
  );
}

export default AllBoatsContainer;
