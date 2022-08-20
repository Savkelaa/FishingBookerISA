import React, { useRef } from "react";
import fishingClassService from "../../Services/FishingClassQuickReservationServices/FishingClassQuickReservationServices";
import rateService from "../../Services/RateServices/RateServices";
import instructor from "../../Services/UserServices/UserServices";
import complainService from "../../Services/ComplaintServices/ComplaintServices"

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
    cottageOwner:reservation.cottage.cottageOwner, 
    client:logedClient,
    accepted:"false",
    request:"true"
  }

  const rateCottage = {
    rate:0,
    cottage:reservation.cottage, 
    client:logedClient,
    accepted:"false",
    request:"true"
  }

  const complaint={
    description:"Los instruktor!",
    client:logedClient,
    cottageQuickReservation:reservation

}

  return (
    <div>
      <Card.Body>
        <div className="popup">
          <h6 for="text">Please rate cottage: </h6>
          <input ref={rate1} type="text" className="form-control" id="start" />
          <button
            onClick={() =>
                {
                    rateCottage.rate=rate1.current.value;
                    rateService.createCottageRate(rateCottage);
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
              rateService.createCottageOwnerRate(rate);
              }
              }
              className="btn btn-success"
          >
            Rate
          </button>
        </div>
      </Card.Body>
      <Card.Body>
        <div className="popup">
          <h6 for="text">
            Make a complaint for: {reservation.cottage.cottageOwner.name}{" "}
            {reservation.cottage.cottageOwner.surname}
          </h6>
          <input ref={zalba} type="text" className="form-control" />
          <button
            onClick={() => {
                complaint.description=zalba.current.value;
                complainService.createCottageComplaint(complaint);
            }}
            className="btn btn-danger"
          >
            Complain
          </button>
        </div>
      </Card.Body>

    </div>
  );
}
