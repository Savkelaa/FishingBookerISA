import React, { useState, useEffect } from "react";
import { useLocation, useHistory } from "react-router";
import boatServices from "../Services/BoatServices/BoatServices";
import background from "../Assets/img/background.jpg";
import "../App.css";
import Navbarr from "../Components/Common/Navbarr";
import Footerr from "../Components/Common/Footerr";
import FcForm from "../Components/Common/FcForm";
import BoatForm from "../Components/Common/BoatForm";
import { useParams } from "react-router";
import boatQuickReservationServices from "../Services/BoatQuickReservationServices/BoatQuickReservationServices";
import rateServices from "../Services/RateServices/RateServices";

 
function BoatContainer() {
  let { id } = useParams();
  const [boat, setBoat] = useState({});
  const [behavioralRule, setbehavioralRule] = useState([]);
  const [additionalItems, setAdditionalItems] = useState([]);
  const [fishingEquipments, setFishingEquipments] = useState([]);
  const [avgRate, setavgRate] = useState([]);
  const [actions, setActions] = useState([]);
  const [images, setImages] = useState([]);
  const [weeklyRes, setWeeklyRes] = useState([]);
  const [monthlyRes, setMonthlyRes] = useState([]);
  const [yearlyRes, setYearlyRes] = useState([]);

  useEffect(() => {
    boatServices
      .getBoatsById(id)
      .then((data) => {
        setBoat(data.data);
      })
      .catch((error) => alert(`error`, error));

      boatServices
      .getWeeklyNumReservationsByBoat(id)
      .then((data) => {
        setWeeklyRes(data.data);
      })
      .catch((error) => alert(`error`, error));

    boatServices
    .getMonthlyNumReservationsByBoat(id)
    .then((data) => {
      setMonthlyRes(data.data);
    })
    .catch((error) => alert(`error`, error));

    boatServices
      .getYearlyNumReservationsByBoat(id)
      .then((data) => {
        setYearlyRes(data.data);
      })
      .catch((error) => alert(`error`, error));

      
    boatServices
      .getBehavioralRuleByBoat(id)
      .then((data) => {
        setbehavioralRule(data.data);
      })
      .catch((error) => alert(`error`, error));

    boatServices
      .getAdditionalServicesByBoat(id)
      .then((data) => {
        setAdditionalItems(data.data);
      })
      .catch((error) => alert(`error`, error));
      
    boatQuickReservationServices
      .getFreeBoatQuickReservation(id)
      .then((data) => {
        setActions(data.data);
      })
      .catch((eror) => alert(`error, error`));
    
      
    boatServices
      .getImagesByBoat(id)
      .then((data) => {
        setImages(data.data);
      })
      .catch((error) => console.log(`error`, error));

    rateServices
      .getAvgRateByBoat(id)
      .then((data) => {
        setavgRate(data.data);
      })
      .catch((error) => console.log(`error`, error));

      boatServices
      .getFishingEquipmentBoat()
      .then((data) => {
        setFishingEquipments(data.data);
      })
      .catch((error) => console.log(`error`, error));
      
  }, []);

  function updateBoat(boat) {
    boatServices
      .updateBoat(boat)
      .then((data) => {
        alert("sucessfuly updated boat");
      })
      .catch((error) => {
        alert("Something wen't wrong try again");
      });
  }

  function deleteBoat(boat) {
    boatServices
        .deleteBoat(boat.id)
        .then((data) => {
        alert("sucessfuly deleted a boat");
        })
        .catch((error) => {
        alert("Something went wrong, please try again");
        });
  }

  return (
    <div>
      <Navbarr></Navbarr>

      <BoatForm
        boat={boat}
        behavioralRule={behavioralRule}
        additionalItems={additionalItems}
        fishingEquipments={fishingEquipments}
        actions={actions}
        avgRate={avgRate}
        updateBoatHandler={updateBoat}
        deleteBoatHandler={deleteBoat}
        images={images}
        weeklyRes={weeklyRes}
        monthlyRes={monthlyRes}
        yearlyRes={yearlyRes}
      ></BoatForm>
      <Footerr></Footerr>
    </div>
  );
}

export default BoatContainer;

