import React, { useRef } from "react";
import { ListGroup, Image } from "react-bootstrap";
import { useParams } from "react-router-dom";

import "../../App.css";
import { BrowserRouter as Link } from "react-router-dom";
import slika from "../../Assets/img/slika1.jpg";
import { Button } from "react-bootstrap";

export default function BoatForm({
  behavioralRule,
  boat,
  additionalItems,
  actions,
  avgRate,
  updateBoatHandler,
  deleteBoatHandler,
  images,
}) {
  console.log(`boat`, boat);
  console.log(`behavioralRule`, behavioralRule);
  console.log(`additionalServices`, additionalItems);
  console.log(`actions`, actions);
  console.log("images", images);
  console.log("averageRate", avgRate);

  const name = useRef();
  const address = useRef();
  const description = useRef();
  const price = useRef();
  const num_motors = useRef();
  const motor_power = useRef();
  const max_speed = useRef();
  const length = useRef();
  const capacity = useRef();
  const cancellation_condition = useRef();
  const type = useRef();

  let { id } = useParams();

  return (
    <div className="container">
      <div className="row gutters">
        <div className="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
          <div className="card h-100">
            <div className="card-body">
              <div className="row gutters">
                <div className="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
                  <h5 className="mb-2 text-primary">Boat Details</h5>
                </div>

                <div className="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                  <div className="form-group">
                    <h6 for="fullName">Name</h6>
                    <input
                      ref={name}
                      type="text"
                      className="form-control"
                      id="fullName"
                      placeholder={boat.name}
                      //value={boat.name}
                    />
                  </div>
                </div>
                <div className="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                  <div className="form-group">
                    <h6 for="eMail">Address</h6>
                    <input
                      ref={address}
                      type="email"
                      className="form-control"
                      id="eMail"
                      //value={boat.address}
                      placeholder={boat.address}
                    />
                    <iframe width="200" height="150" id="gmap_canvas" src={boat.url} 
                      frameborder="0" scrolling="no" marginheight="0" marginwidth="0">
                    </iframe>
                  </div>
                </div>

                <div className="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                  <div className="form-group">
                    <h6 for="numRooms">Number of Motors</h6>
                    <input
                      ref={num_motors}
                      type="number"
                      className="form-control"
                      id="numRooms"
                      value={boat.num_motors}
                    />
                  </div>
                </div>

                <div className="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                  <div className="form-group">
                    <h6 for="numBeds">Type </h6>
                    <input
                      ref={type}
                      type="text"
                      className="form-control"
                      id="numBeds"
                      value={boat.type}
                    />
                  </div>
                </div>

                <div className="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                  <div className="form-group">
                    <h6 for="numBeds">Length </h6>
                    <input
                      ref={length}
                      type="number"
                      className="form-control"
                      id="numBeds"
                      value={boat.length}
                    />
                  </div>
                </div>

                <div className="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                  <div className="form-group">
                    <h6 for="numBeds">Max speed </h6>
                    <input
                      ref={max_speed}
                      type="number"
                      className="form-control"
                      id="numBeds"
                      value={boat.maxSpeed}
                    />
                  </div>
                </div>

                <div className="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                  <div className="form-group">
                    <h6 for="numBeds">Motor Power </h6>
                    <input
                      ref={motor_power}
                      type="number"
                      className="form-control"
                      id="numBeds"
                      value={boat.motorPower}
                    />
                  </div>
                </div>

                <div className="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                  <div className="form-group">
                    <h6 for="eMail">Capacity</h6>
                    <input
                      ref={address}
                      type="email"
                      className="form-control"
                      id="eMail"
                      //value={boat.address}
                      placeholder={boat.capacity}
                    />
                  </div>
                </div>

                <div className="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                  <div className="form-group">
                    <h6 for="phone">Promotion description</h6>
                    <input
                      ref={description}
                      type="text"
                      className="form-control"
                      id="phone"
                      //value={boat.promoDescription}
                      placeholder={boat.promoDescription}
                    />
                  </div>
                </div>

                <div className="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                  <div className="form-group">
                    <h6 for="phone">Cancellation condition</h6>
                    <input
                      ref={cancellation_condition}
                      type="text"
                      className="form-control"
                      id="phone"
                      //value={boat.promoDescription}
                      placeholder={boat.cancellationCondition}
                    />
                    <ListGroup>
                      <ListGroup.Item>
                        {boat.cancellationCondition} % of the total price you
                        have to pay to cancel the reservation
                      </ListGroup.Item>
                    </ListGroup>
                  </div>
                </div>

                <div className="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                  <div className="form-group">
                    <h6 for="phone">Average Rate</h6>
                    <input
                      ref={description}
                      type="text"
                      className="form-control"
                      id="phone"
                      value={avgRate}
                    />
                  </div>
                </div>

                <div className="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                  <div className="form-group">
                    <h6 for="website">Price</h6>
                    <input
                      ref={price}
                      type="number"
                      className="form-control"
                      id="price"
                      // value={boat.price}
                      placeholder={boat.price}
                    />
                  </div>
                </div>
              </div>

              <div className="row gutters">
                <div className="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                  <div className="form-group">
                    <h6 for="ciTy">Behavioral Rule</h6>
                    <ListGroup>
                      {behavioralRule.map((rule) => (
                        <ListGroup.Item>{rule.name}</ListGroup.Item>
                      ))}
                    </ListGroup>
                  </div>
                </div>

                <div className="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                  <div className="form-group">
                    <h6 for="sTate"> Boat Actions</h6>
                    <ListGroup>
                      {actions.map((action) => (
                        <ListGroup.Item>
                          StartDateAction: {action.startDateAction} <br></br>
                          EndDateAction: {action.finishDateAction}
                          <br></br>
                          Price per day : {action.price} euro,{" "}
                        </ListGroup.Item>
                      ))}
                    </ListGroup>
                  </div>
                </div>

                <div className="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                  <div className="form-group">
                    <h6 for="sTate">Additional Items</h6>
                    <ListGroup>
                      {additionalItems.map((additionalItem) => (
                        <ListGroup.Item>
                          {additionalItem.name} : {additionalItem.price} euro
                        </ListGroup.Item>
                      ))}
                    </ListGroup>
                  </div>
                </div>
              </div>

              <div className="form-group">
                <h6 for="sTate">Images: </h6>
                {images.map((slika, index) => (
                  <img
                    className="img-fluid"
                    alt={slika.url}
                    src={slika.url}
                    width="200"
                    height="200"
                    position="absolute"
                  />
                ))}
              </div>

              <div className="row gutters">
                <div className="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
                  <div className="text-right">
                    <button
                      type="button"
                      id="submit"
                      name="submit"
                      className="btn btn-secondary"
                      onClick={() => {
                        boat.name = name.current.value;
                        boat.address = address.current.value;

                        boat.price = price.current.value;

                        boat.promoDescription = description.current.value;

                        updateBoatHandler(boat);
                      }}
                    >
                      Update
                    </button>

                    <button
                      type="button"
                      id="submit"
                      name="submit"
                      className="btn btn-danger"
                      onClick={() => {
                        deleteBoatHandler(boat);
                      }}
                    >
                      Delete
                    </button>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}
