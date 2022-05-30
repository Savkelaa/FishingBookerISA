import React, { useRef } from "react";
import { useHistory } from "react-router-dom";
import { useParams } from "react-router-dom";

export default function CreateCottageForm({ createCottageHandler }) {
  const name = useRef();
  const address = useRef();
  const promoDescription = useRef();
  const numRooms = useRef();
  const numBeds = useRef();
  const price = useRef();

  var logedCottageOwner = JSON.parse(localStorage.getItem("CottageOwner"));

  function saveHandler(e) {
    createCottageHandler({
      name: name.current.value,
      address: address.current.value,
      promoDescription: promoDescription.current.value,
      numRooms: numRooms.current.value,
      numBeds: numBeds.current.value,
      cottageOwner: { id: logedCottageOwner.id },
      price: price.current.value,
    });
  }

  console.log("id", logedCottageOwner.id);

  return (
    <form action="javascript:void(0);" onSubmit={saveHandler}>
      <div className="container">
        <div className="row gutters">
          <div className="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
            <div className="card h-100">
              <div className="card-body">
                <div className="row gutters">
                  <div className="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
                    <h5 className="mb-2 text-primary">
                      Create Cottage
                    </h5>
                  </div>
                  <div className="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                    <h6 for="start_date_action">Name</h6>
                    <input
                      ref={name}
                      type="text"
                      className="form-control"
                      id="startAction"
                    />
                  </div>
                  <div className="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                    <h6 for="end_date_action">Address</h6>
                    <input
                      ref={address}
                      type="text"
                      className="form-control"
                      id="lastAction"
                    />
                  </div>
                  <div className="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                    <h6 for="end_date_action">Promotion Description</h6>
                    <input
                      ref={promoDescription}
                      type="text"
                      className="form-control"
                      id="lastAction"
                    />
                  </div>
                  
                  
                  <div className="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                    <h6 for="start_date">Number of rooms</h6>
                    <input
                      ref={numRooms}
                      type="text"
                      className="form-control"
                      id="last"
                    />
                  </div>

                  <div className="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                    <h6 for="start_date">Number of beds</h6>
                    <input
                      ref={numBeds}
                      type="text"
                      className="form-control"
                      id="last"
                    />
                  </div>

                  <div className="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                    <h6 for="start_date">Price</h6>
                    <input
                      ref={price}
                      type="text"
                      className="form-control"
                      id="last"
                    />
                  </div>
                </div>
                <div className="row gutters">
                  <div className="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
                    <div className="text-right">
                      <button
                        type="submit"
                        id="submit"
                        name="submit"
                        className="btn btn-success"
                      >
                        Create
                      </button>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </form>
  );
}
