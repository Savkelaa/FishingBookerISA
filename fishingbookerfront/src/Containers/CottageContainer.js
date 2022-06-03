import React, { useState, useEffect } from "react";
import { useLocation, useHistory } from "react-router";
import cottageServices from "../Services/CottageServices/CottageServices";
import background from "../Assets/img/background.jpg";
import "../App.css";
import Navbarr from "../Components/Common/Navbarr";
import Footerr from "../Components/Common/Footerr";
import FcForm from "../Components/Common/FcForm";
import CottageForm from "../Components/Common/CottageForm";
import { useParams } from "react-router";
import cottageQuickReservationServices from "../Services/CottageQuickReservationServices/CottageQuickReservationServices";
import rateServices from "../Services/RateServices/RateServices";

function CottageContainer() {
  let { id } = useParams();
  const [cottage, setCottage] = useState({});
  const [behavioralRule, setbehavioralRule] = useState([]);
  const [additionalItems, setAdditionalItems] = useState([]);
  const [avgRate, setavgRate] = useState([]);
  const [actions, setActions] = useState([]);
  const [images, setImages] = useState([]);

  useEffect(() => {
    cottageServices
      .getCottagesById(id)
      .then((data) => {
        setCottage(data.data);
      })
      .catch((error) => alert(`error`, error));

      
    cottageServices
      .getBehavioralRuleByCottage(id)
      .then((data) => {
        setbehavioralRule(data.data);
      })
      .catch((error) => alert(`error`, error));

    cottageServices
      .getAdditionalServicesByCottage(id)
      .then((data) => {
        setAdditionalItems(data.data);
      })
      .catch((error) => alert(`error`, error));

    cottageQuickReservationServices
      .getFreeCottageQuickReservation(id)
      .then((data) => {
        setActions(data.data);
      })
      .catch((eror) => alert(`error, error`));
    
      
    cottageServices
      .getImagesByCottage(id)
      .then((data) => {
        setImages(data.data);
      })
      .catch((error) => console.log(`error`, error));

    rateServices
      .getAvgRateByCottage(id)
      .then((data) => {
        setavgRate(data.data);
      })
      .catch((error) => console.log(`error`, error));
      
  }, []);

  function updateCottage(cottage) {
    cottageServices
      .updateCottage(cottage)
      .then((data) => {
        alert("sucessfuly updated cottage");
      })
      .catch((error) => {
        alert("Something wen't wrong try again");
      });
  }

  function deleteCottage(cottage) {
    cottageServices
        .deleteCottage(cottage.id)
        .then((data) => {
        alert("sucessfuly deleted a cottage");
        })
        .catch((error) => {
        alert("Something went wrong, please try again");
        });
  }

  return (
    <div>
      <Navbarr></Navbarr>

      <CottageForm
        cottage={cottage}
        behavioralRule={behavioralRule}
        additionalItems={additionalItems}
        actions={actions}
        avgRate={avgRate}
        updateCottageHandler={updateCottage}
        deleteCottageHandler={deleteCottage}
        images={images}
      ></CottageForm>
      <Footerr></Footerr>
    </div>
  );
}

export default CottageContainer;

