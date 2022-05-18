import React, { useRef } from "react";
import { ListGroup, Image } from "react-bootstrap";

import "../../App.css";
import { BrowserRouter as Link } from "react-router-dom";
import slika from "../../Assets/img/slika1.jpg";
import Box from "@mui/material/Box";
import ImageList from "@mui/material/ImageList";

export default function FcForm({
  behavioralRule,
  fishingClass,
  additionalItems,
  updateFishingClassHandler,
  images,
}) {
  console.log(`fishingClass`, fishingClass);
  console.log(`behavioralRule`, behavioralRule);
  console.log(`additionalServices`, additionalItems);
  console.log("images", images);

  const name = useRef();
  const address = useRef();
  const description = useRef();
  const maxPeople = useRef();
  const biography = useRef();
  const conditions = useRef();
  const price = useRef();

  return (
    <div className="container">
      <div className="row gutters">
        <div className="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
          <div className="card h-100">
            <div className="card-body">
              <div className="row gutters">
                <div className="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
                  <h5 className="mb-2 text-primary">Fishing Class Details</h5>
                </div>
                <div className="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                  <div className="form-group">
                    <h6 for="fullName">Name</h6>
                    <input
                      ref={name}
                      type="text"
                      className="form-control"
                      id="fullName"
                      //value={fishingClass.name}
                      placeholder={fishingClass.name}
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
                      //value={fishingClass.address}
                      placeholder={fishingClass.address}
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
                      //value={fishingClass.promoDescription}
                      placeholder={fishingClass.promoDescription}
                    />
                  </div>
                </div>
                <div className="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                  <div className="form-group">
                    <h6 for="website">Max number of people</h6>
                    <input
                      ref={maxPeople}
                      type="url"
                      className="form-control"
                      id="website"
                      // value={fishingClass.maxPeople}
                      placeholder={fishingClass.maxPeople}
                    />
                  </div>
                </div>
                <div className="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                  <div className="form-group">
                    <h6 for="website">Price</h6>
                    <input
                      ref={price}
                      type="url"
                      className="form-control"
                      id="website"
                      // value={fishingClass.maxPeople}
                      placeholder={fishingClass.price}
                    />
                  </div>
                </div>
              </div>
              <div className="row gutters">
                <div className="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                  <div className="form-group">
                    <h6 for="Street">Instructor biography</h6>
                    <input
                      ref={biography}
                      type="name"
                      className="form-control"
                      id="Street"
                      // value={fishingClass.instructor?.shortBiography}
                      placeholder={fishingClass.instructor?.shortBiography}
                    />
                  </div>
                </div>
                <div className="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                  <div className="form-group">
                    <h6 for="zIp">Cancelation conditions</h6>
                    <input
                      ref={conditions}
                      type="name"
                      className="form-control"
                      id="Street"
                      //value={fishingClass.instructor?.shortBiography}
                      placeholder={fishingClass.cancellationCondition}
                    />
                    <ListGroup>
                      <ListGroup.Item>
                        {fishingClass.cancellationCondition} % of the total
                        price you have to pay to cancel the reservation
                      </ListGroup.Item>
                    </ListGroup>
                  </div>
                </div>
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
                    <h6 for="sTate">Aditional Items</h6>
                    <ListGroup>
                      {additionalItems.map((additionalItem) => (
                        <ListGroup.Item>
                          {additionalItem.name} : {additionalItem.price} euro
                        </ListGroup.Item>
                      ))}
                    </ListGroup>
                  </div>
                </div>
                <div className="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                  <div className="form-group">
                    <h6 for="sTate">Aditional Items</h6>
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
              <div className="row gutters">
                <div className="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
                  <div className="text-right">
                    <button
                      type="button"
                      id="submit"
                      name="submit"
                      className="btn btn-secondary"
                      onClick={() => {
                        fishingClass.name = name.current.value;
                        fishingClass.address = address.current.value;
                        fishingClass.maxPeople = maxPeople.current.value;
                        fishingClass.price = price.current.value;
                        fishingClass.cancellationCondition =
                          conditions.current.value;
                        fishingClass.promoDescription =
                          description.current.value;
                        fishingClass.instructor.shortBiography =
                          biography.current.value;

                        updateFishingClassHandler(fishingClass);
                      }}
                    >
                      Update
                    </button>

                    <button
                      type="button"
                      id="submit"
                      name="submit"
                      className="btn btn-danger"
                    >
                      Delete
                    </button>
                  </div>
                </div>
              </div>

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
          </div>
        </div>
      </div>
    </div>
  );
}
