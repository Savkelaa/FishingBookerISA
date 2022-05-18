import React, { useState, useEffect } from "react";
import { useLocation, useHistory } from "react-router";
import fishingClassServices from "../Services/FishingClassServices/FishingClassServices";
import background from "../Assets/img/background.jpg";
import "../App.css";
import Navbarr from "../Components/Common/Navbarr";
import Footerr from "../Components/Common/Footerr";
import FcForm from "../Components/Common/FcForm";
import { useParams } from "react-router";

function FishingClassContainer() {
  let { id } = useParams();
  const [fishingClass, setFishingClass] = useState({});
  const [behavioralRule, setbehavioralRule] = useState([]);
  const [additionalItems, setAdditionalItems] = useState([]);
  const [images, setImages] = useState([]);

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

    fishingClassServices
      .getAdditionalServiceByFishingClass(id)
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
  }, []);

  function updateFishingClass(fishingClass) {
    fishingClassServices
      .updateFishingClass(fishingClass)
      .then((data) => {
        console.log("sucessfuly updated fishingClass");
      })
      .catch((error) => {
        console.log("Something wen't wrong try again");
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
        images={images}
      ></FcForm>
      <Footerr></Footerr>
    </div>
  );
}

export default FishingClassContainer;
