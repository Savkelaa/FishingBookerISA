import React, { useState, useEffect } from "react";
import { useLocation, useHistory } from "react-router";
import fishingClassServices from "../Services/FishingClassServices/FishingClassServices";
import background from "../Assets/img/background.jpg";
import "../App.css";
import Navbarr from "../Components/Common/Navbarr";
import Footerr from "../Components/Common/Footerr";
import FcForm from "../Components/Common/FcForm";

function FishingClassContainer() {
  const history = useHistory();
  const filterParams = new URLSearchParams(useLocation().search);

  const [fishingClass, setFishingClass] = useState({});
  const [behavioralRule, setbehavioralRule] = useState([]);
  const [additionalItems, setAdditionalItems] = useState([]);

  useEffect(() => {
    fishingClassServices
      .getFishingClassById(1)
      .then((data) => {
        setFishingClass(data.data);
      })
      .catch((error) => console.log(`error`, error));

    fishingClassServices
      .getBehavioralRuleByFishingClass(1)
      .then((data) => {
        setbehavioralRule(data.data);
      })
      .catch((error) => console.log(`error`, error));

    fishingClassServices
      .getAdditionalServiceByFishingClass(2)
      .then((data) => {
        setAdditionalItems(data.data);
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

      <FcForm
        fishingClass={fishingClass}
        behavioralRule={behavioralRule}
        additionalItems={additionalItems}
      ></FcForm>
      <Footerr></Footerr>
    </div>
  );
}

export default FishingClassContainer;
