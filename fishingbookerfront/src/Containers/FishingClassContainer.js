import React, { useState, useEffect } from "react";
import { useLocation, useHistory } from "react-router";
import fishingClassServices from "../Services/FishingClassServices/FishingClassServices";
import background from "../Assets/img/background.jpg";
import "../App.css";
import Navbarr from "../Components/Common/Navbarr";
import Footerr from "../Components/Common/Footerr";
import FcForm from "../Components/Common/FcForm";
import { useParams } from "react-router";
import fishingClassQuickReservationServices from "../Services/FishingClassQuickReservationServices/FishingClassQuickReservationServices";
import rateServices from "../Services/RateServices/RateServices";

function FishingClassContainer() {
  let { id } = useParams();
  const [fishingClass, setFishingClass] = useState({});
  const [behavioralRule, setbehavioralRule] = useState([]);
  const [additionalItems, setAdditionalItems] = useState([]);
  const [images, setImages] = useState([]);
  const [fishingClassQuickReservations, setFishingClassQuickReservations] =
    useState([]);
  const [avgRate, setavgRate] = useState();
  const [fishingEquipments, setFishingEquipments] = useState([]);

  const history = useHistory();

  useEffect(() => {
    fishingClassServices
      .getFishingClassById(id)
      .then((data) => {
        setFishingClass(data.data);
      })
      .catch((error) => console.log(`error`, error));

    fishingClassServices
      .getBehavioralRuleByFishingClass(id)
      .then((data) => {
        setbehavioralRule(data.data);
      })
      .catch((error) => console.log(`error`, error));

    fishingClassQuickReservationServices
      .getAllAdditionalServices()

      .then((data) => {
        setAdditionalItems(data.data);
      })
      .catch((error) => console.log(`error`, error));

    fishingClassServices
      .imagesByFishingClass(id)
      .then((data) => {
        setImages(data.data);
      })
      .catch((error) => console.log(`error`, error));

    fishingClassQuickReservationServices
      .getAllFishingClassQuickReservationsByFishingClass(id)
      .then((data) => {
        setFishingClassQuickReservations(data.data);
      })
      .catch((error) => console.log(`error`, error));

    rateServices
      .getAvgRateByFishingClass(id)
      .then((data) => {
        setavgRate(data.data);
      })
      .catch((error) => console.log(`error`, error));

    fishingClassServices
      .getFishingEquipmentFC()
      .then((data) => {
        setFishingEquipments(data.data);
      })
      .catch((error) => console.log(`error`, error));
  }, []);

  function updateFishingClass(fishingClass) {
    fishingClassServices
      .updateFishingClass(fishingClass)
      .then((data) => {
        console.log("sucessfuly updated fishingClass");
        alert("sucessfuly updated fishingClass");
      })
      .catch((error) => {
        console.log("Something wen't wrong try again");
      });
  }
  function deleteFishingClass(fishingClass) {
    fishingClassServices
      .deleteFishingClass(fishingClass.id)
      .then((data) => {
        alert("sucessfuly deleted a cottage");
        history.push("/fishingClassByInstructor");
      })
      .catch((error) => {
        alert(
          "You cant delete fishing class because fishin class has rezervations."
        );
      });
  }

  return (
    <div>
      <Navbarr></Navbarr>

      <FcForm
        fishingClass={fishingClass}
        behavioralRule={behavioralRule}
        additionalItems={additionalItems}
        updateFishingClassHandler={updateFishingClass}
        fishingClassQuickReservations={fishingClassQuickReservations}
        images={images}
        avgRate={avgRate}
        fishingEquipments={fishingEquipments}
        deleteFishingClassHandler={deleteFishingClass}
      ></FcForm>
      <Footerr></Footerr>
    </div>
  );
}

export default FishingClassContainer;
