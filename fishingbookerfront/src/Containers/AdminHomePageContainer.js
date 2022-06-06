import React, { useEffect, useState } from "react";
import Navbarr from "../Components/Common/Navbarr";
import Footerr from "../Components/Common/Footerr";
import Profile from "../Components/Common/Profile";
import AdministratorHomeButtons from "../Components/Common/AdministratorHomeButtons";
import AdminProfilePicture from "../Components/HomePageComponents/AdminProfilePicture";
import AdminProfileLabels from "../Components/HomePageComponents/AdminProfileLabels";
import userServices from "../Services/UserServices/UserServices";
import fishingClassQuickReservationServices from "../Services/FishingClassQuickReservationServices/FishingClassQuickReservationServices";
import NavbarAdmin from "../Components/Common/NavbarAdmin";

export default function AdminHomePageContainer() {
  var logedAdmin = JSON.parse(localStorage.getItem("Admin"));
  const [priceFishingClass, setpriceFishingClass] = useState();
  const [priceFishingClassQuick, setPriceFishingClassQuick] = useState();
  const [priceBoat, setpriceBoat] = useState();
  const [priceBoatQuick, setpriceBoatQuick] = useState();
  const [priceCottage, setpriceCottage] = useState();
  const [priceCottageQuick, setpriceCottageQuick] = useState();
  const [admin, setadmin] = useState();

  const [totalPrice, settotalPrice] = useState();

  useEffect(() => {
    var countTotal = 0;
    var logedAdmin = JSON.parse(localStorage.getItem("Admin"));

    fishingClassQuickReservationServices
      .getTotalPriceCompletedFishinClassReservations()
      .then((data) => {
        setpriceFishingClass(data.data);
        console.log("numFishing", data.data);
        countTotal = countTotal + data.data;
      })
      .catch((error) => console.log(`error`, error));

    fishingClassQuickReservationServices
      .getTotalPriceCompletedFishinClassQuickReservations()
      .then((data) => {
        setPriceFishingClassQuick(data.data);
        console.log("numFishingQuick", data.data);
        countTotal = countTotal + data.data;
      })
      .catch((error) => console.log(`error`, error));

    fishingClassQuickReservationServices
      .getTotalPriceCompletedBoatReservations()
      .then((data) => {
        setpriceBoat(data.data);
        console.log("numBoat", data.data);
        countTotal = countTotal + data.data;
      })
      .catch((error) => console.log(`error`, error));

    fishingClassQuickReservationServices
      .getTotalPriceCompletedBoatQuickReservations()
      .then((data) => {
        setpriceBoatQuick(data.data);
        console.log("numBoatQuick", data.data);
        countTotal = countTotal + data.data;
      })
      .catch((error) => console.log(`error`, error));

    fishingClassQuickReservationServices
      .getTotalPriceCompletedCottageReservations()
      .then((data) => {
        setpriceCottage(data.data);
        console.log("numCottage", data.data);
        countTotal = countTotal + data.data;
      })
      .catch((error) => console.log(`error`, error));

    fishingClassQuickReservationServices
      .getTotalPriceCompletedCottageQuickReservations()
      .then((data) => {
        setpriceCottageQuick(data.data);
        console.log("numCottageQUick", data.data);
        countTotal = countTotal + data.data;
        settotalPrice(countTotal * (0.01 * logedAdmin.percentage));

        console.log("totalPrice", totalPrice);
      })
      .catch((error) => console.log(`error`, error));
  }, []);

  function updateAdmin(admin) {
    userServices
      .updateAdmin(admin)
      .then((data) => {
        console.log("sucessfuly updated Admin");
        alert("sucessfuly updated Admin");
        setadmin(logedAdmin);
      })
      .catch((error) => {
        console.log("Something wen't wrong try again");
      });
  }

  return (
    <div>
      <NavbarAdmin></NavbarAdmin>
      <div className="container rounded bg-white mt-5 mb-5">
        <div className="row">
          <AdminProfilePicture logedAdmin={logedAdmin}></AdminProfilePicture>
          <AdminProfileLabels
            totalPrice={totalPrice}
            updateAdminHandler={updateAdmin}
            logedAdmin={logedAdmin}
          ></AdminProfileLabels>
          <AdministratorHomeButtons></AdministratorHomeButtons>
        </div>
      </div>
      <Footerr></Footerr>
    </div>
  );
}
