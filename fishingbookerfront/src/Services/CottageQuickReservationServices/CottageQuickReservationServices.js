const axios = require("axios");

const cottageQuickReservationServices = {

    getAllCottageQuickReservationsByOwner: (ownerId) => {
        return axios.get(
        `${process.env.REACT_APP_API_URL}cottageQuickReservationsByOwner?cottageOwnerId=${ownerId}`
        );
    },

    getAllCottageReservationsByOwner: (ownerId) => {
        return axios.get(
        `${process.env.REACT_APP_API_URL}cottageReservationsByOwner?cottageOwnerId=${ownerId}`
        );
    },

    getAllCottageReservationsByClient: (clientId) => {
        return axios.get(
          `${process.env.REACT_APP_API_URL}cottageReservationsClient?clientId=${clientId}`
        );
    },
    
    createCottageQuickReservationAction: (cottageAction) => {
        return axios.post(
            `${process.env.REACT_APP_API_URL}cottageQuickReservations`,
        cottageAction
        );
    },

    createCottageReservation: (cottage) => {
        return axios.post(
            `${process.env.REACT_APP_API_URL}cottageReservations`,
        cottage
        );
    },

    getFreeCottageQuickReservation: (cottageId) => {
        return axios.get(
            `${process.env.REACT_APP_API_URL}freeCottageQuickReservationsByCottage?cottageId=${cottageId}`,
        );
    },

};

export default cottageQuickReservationServices;