import { Injectable } from "@nestjs/common";
import { InjectRepository } from "@nestjs/typeorm";
import { User } from "./user.entity";
import { Repository } from "typeorm";

@Injectable()
export class UserService{
    constructor(@InjectRepository(User)private readonly repository:Repository<User>){}
    async create(user:User):Promise<User>{
        return this.repository.save(user);
    }
    async findAll():Promise<User[]>{
        return this.repository.find();
    }
    async findOne(id:number):Promise<User>{
        const data = await this.repository.findOne({where:{id}});
        if(!data){
            throw new Error(`User with id ${id} not found`);
        }
        return data;
    }
    async update(id:number, user:User):Promise<User>{
        await this.repository.update(id, user);
        return this.findOne(id);
    }
    async remove(id:number):Promise<void>{
        await this.repository.delete(id);
    }
    async softRemove(id:number):Promise<void>{
        await this.repository.softDelete(id);
    }


}