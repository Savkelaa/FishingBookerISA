import React, { useRef } from "react";
import fishingClassService from "../../Services/FishingClassQuickReservationServices/FishingClassQuickReservationServices";
import rateService from "../../Services/RateServices/RateServices";
import instructor from "../../Services/UserServices/UserServices";

import {
  Card,
  ListGroup,
  ListGroupItem,
  CardGroup,
  Button,
} from "react-bootstrap";

export default function RateAndComplaint({
  reservation,
}) {
  var logedClient = JSON.parse(localStorage.getItem("Client"));
  console.log("logedClient", logedClient);

  const rate1 = useRef();
  const rate2 = useRef();
  const zalba = useRef();
  

  const rate = {
    rate:0,
    boatOwner:reservation.boat.boatOwner, 
    client:logedClient,
    accepted:"false",
    request:"true"
  }

  return (
    <div>
      <Card.Body>
        <div className="popup">
          <h6 for="text">Please rate boat: </h6>
          <input ref={rate1} type="text" className="form-control" id="start" />
          <button
           onClick={() =>{
            rate.rate=rate2.current.value;
            rateService.createBoatOwnerRate(rate);
            }
            }
            className="btn btn-success"
          >
            Rate
          </button>
          <br></br>
          <br></br>
          <h6 for="text">Please rate owner: </h6>
          <input
            ref={rate2}
            type="refusalReason"
            className="form-control"
            id="refusalReason"
          />
          <button
            onClick={() =>{
            rate.rate=rate2.current.value;
            rateService.createBoatOwnerRate(rate);
            }
            }
            className="btn btn-success"
          >
            Rate
          </button>
        </div>
      </Card.Body>
    </div>
  );
}
