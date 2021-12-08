import React from "react";
import { ListGroup, Image } from "react-bootstrap";

import "../../App.css";
import { BrowserRouter as Link } from "react-router-dom";

export default function FcForm({
  behavioralRule,
  fishingClass,
  additionalItems,
}) {
  console.log(`fishingClass`, fishingClass);
  console.log(`behavioralRule`, behavioralRule);
  console.log(`additionalServices`, additionalItems);
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
                      type="text"
                      className="form-control"
                      id="fullName"
                      value={fishingClass.name}
                    />
                  </div>
                </div>
                <div className="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                  <div className="form-group">
                    <h6 for="eMail">Address</h6>
                    <input
                      type="email"
                      className="form-control"
                      id="eMail"
                      value={fishingClass.address}
                    />
                  </div>
                </div>
                <div className="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                  <div className="form-group">
                    <h6 for="phone">Promotion description</h6>
                    <input
                      type="text"
                      className="form-control"
                      id="phone"
                      value={fishingClass.promoDescription}
                    />
                  </div>
                </div>
                <div className="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                  <div className="form-group">
                    <h6 for="website">Max number of people</h6>
                    <input
                      type="url"
                      className="form-control"
                      id="website"
                      value={fishingClass.maxPeople}
                    />
                  </div>
                </div>
              </div>
              <div className="row gutters">
                <div className="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                  <div className="form-group">
                    <h6 for="Street">Instructor biography</h6>
                    <input
                      type="name"
                      className="form-control"
                      id="Street"
                      value={fishingClass.instructor?.shortBiography}
                    />
                  </div>
                </div>
                <div className="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                  <div className="form-group">
                    <h6 for="zIp">Cancelation conditions</h6>
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
                    <Link to="/dashboard">
                      <button
                        type="button"
                        id="submit"
                        name="submit"
                        className="btn btn-success"
                      >
                        Reserve
                      </button>
                    </Link>

                    <button
                      type="button"
                      id="submit"
                      name="submit"
                      className="btn btn-primary"
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
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}
