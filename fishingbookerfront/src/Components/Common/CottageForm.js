import React, { useRef } from "react";
import { ListGroup, Image } from "react-bootstrap";

import "../../App.css";
import { BrowserRouter as Link } from "react-router-dom";
import slika from "../../Assets/img/slika1.jpg";

export default function CottageForm({
  behavioralRule,
  cottage,
  additionalItems,
  updateCottageHandler,
  deleteCottageHandler,
  images,
}) {
  console.log(`cottage`, cottage);
  console.log(`behavioralRule`, behavioralRule);
  console.log(`additionalServices`, additionalItems);
  //console.log("images", images);

  const name = useRef(cottage.name);
  const address = useRef(cottage.address);
  const description = useRef(cottage.description);
  const price = useRef(cottage.price);
  const num_rooms = useRef(cottage.numRooms);
  const num_beds = useRef(cottage.numBeds);

  return (
    <div className="container">
      <div className="row gutters">
        <div className="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
          <div className="card h-100">
            <div className="card-body">
              <div className="row gutters">
                <div className="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
                  <h5 className="mb-2 text-primary">Cottage Details</h5>
                </div>
                <div className="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                  <div className="form-group">
                    <h6 for="fullName">Name</h6>
                    <input
                      ref={name}
                      type="text"
                      className="form-control"
                      id="fullName"
                      placeholder={cottage.name}
                      //value={cottage.name}
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
                      //value={cottage.address}
                      placeholder={cottage.address}
                    />
                  </div>
                </div>

                <div className="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                  <div className="form-group">
                    <h6 for="numRooms">Number of Rooms</h6>
                    <input
                      ref={num_rooms}
                      type="number"
                      className="form-control"
                      id="numRooms"
                      
                      value={cottage.numRooms}
                    
                    />
                  </div>
                </div>

                <div className="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                  <div className="form-group">
                    <h6 for="numBeds">Number of Beds</h6>
                    <input
                      ref={num_beds}
                      type="number"
                      className="form-control"
                      id="numBeds"
                      value={cottage.numBeds}
                      
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
                      //value={cottage.promoDescription}
                      placeholder={cottage.promoDescription}
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
                     // value={cottage.price}
                      placeholder={cottage.price}
                      
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

              <Link to="cottageAvailabilityPeriod">
                <button className="btn btn-primary profile-button" type="button">
                  Enter availability period
                </button>
              </Link>
            

              <div className="row gutters">
                <div className="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
                  <div className="text-right">
                    <button
                      type="button"
                      id="submit"
                      name="submit"
                      className="btn btn-secondary"
                      onClick={() => {
                        cottage.name = name.current.value;
                        cottage.address = address.current.value;
                        
                        cottage.price = price.current.value;
                        
                        cottage.promoDescription =
                          description.current.value;

                      


                        updateCottageHandler(cottage);
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
                        deleteCottageHandler(cottage)
                      }
                    }
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
