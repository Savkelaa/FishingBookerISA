const axios = require("axios");

const boatQuickReservationServices = {
  getAllBoatQuickReservationsByOwner: (ownerId) => {
    return axios.get(
      `${process.env.REACT_APP_API_URL}boatQuickReservationsByOwner?boatOwnerId=${ownerId}`
    );
  },

  getAllBoatQuickReservations: () => {
    return axios.get(
      `${process.env.REACT_APP_API_URL}boatQuickReservations2`
    );
  },


  getAllBoatReservationsByOwner: (ownerId) => {
    return axios.get(
      `${process.env.REACT_APP_API_URL}boatReservationsByOwner?boatOwnerId=${ownerId}`
    );
  },

  getAllBoatReservationsByClient2: (clientId) => {
    return axios.get(
      `${process.env.REACT_APP_API_URL}allBoatReservationsByClient?clientId=${clientId}`
    );
  },
  getAllBoatReservationsByClient: (clientId) => {
    return axios.get(
      `${process.env.REACT_APP_API_URL}allBoatQuickReservationsByClient?clientId=${clientId}`
    );
  },
  

  createBoatQuickReservationAction: (boatAction) => {
    return axios.post(
      `${process.env.REACT_APP_API_URL}boatQuickReservations`,
      boatAction
    );
  },

  createBoatReservation: (boat) => {
    return axios.post(
      `${process.env.REACT_APP_API_URL}boatReservations`,
      boat
    );
  },
  UPBoatReservation: (BoatQuickReservation ) => {
    return axios.put(
      `${process.env.REACT_APP_API_URL}boatQuickReservations/${BoatQuickReservation.id}}`,
      BoatQuickReservation
    );
  },

  deleteBoatQuickReservation: (boatId) => {
    return axios.delete(
      `${process.env.REACT_APP_API_URL}boatQuickReservations/${boatId}`
    );
  },

  deleteBoatOrdinaryReservation: (boatId) => {
    return axios.delete(
      `${process.env.REACT_APP_API_URL}boatReservations/${boatId}`
    );
  },


  

  getFreeBoatQuickReservation: (boatId) => {
    return axios.get(
      `${process.env.REACT_APP_API_URL}freeBoatQuickReservationsByBoat?boatId=${boatId}`
    );
  },

  ////ZA KALENDAR BOATRESERVATION

  getAllBoatReservationsByBoatOwner: (boatOwnerId) => {
    return axios.get(
      `${process.env.REACT_APP_API_URL}boatReservationBoatOwner?boatOwnerId=${boatOwnerId}`
    );
  },

  getAllBoatQuickReservationsByBoatOwner: (boatOwnerId) => {
    return axios.get(
      `${process.env.REACT_APP_API_URL}boatQuickReservationBoatOwner?boatOwnerId=${boatOwnerId}`
    );
  },

  getBoatQuickReservationByBoat: (boatId) => {
    return axios.get(
      `${process.env.REACT_APP_API_URL}BoatQuickReservationsByBoat?boatId=${boatId}`
    );
  },

  getBoatQuickReservationByDateAsc: (clientId) => {
    return axios.get(
      `${process.env.REACT_APP_API_URL}allFinishedBoatQuickReservationsByClientSortedByDateAsc?clientId=${clientId}`
    );
  },

  getBoatQuickReservationByDateDesc: (clientId) => {
    return axios.get(
      `${process.env.REACT_APP_API_URL}allFinishedBoatQuickReservationsByClientSortedByDateDesc?clientId=${clientId}`
    );
  },

  getBoatQuickReservationByDurationAsc: (clientId) => {
    return axios.get(
      `${process.env.REACT_APP_API_URL}allFinishedBoatQuickReservationsByClientSortedByDurationAsc?clientId=${clientId}`
    );
  },

  getBoatQuickReservationByDurationDesc: (clientId) => {
    return axios.get(
      `${process.env.REACT_APP_API_URL}allFinishedBoatQuickReservationsByClientSortedByDurationDesc?clientId=${clientId}`
    );
  },

};

export default boatQuickReservationServices;
