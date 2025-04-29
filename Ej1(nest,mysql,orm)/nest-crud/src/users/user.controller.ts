import { Controller, Get, Post, Put, Delete,Param, Body } from "@nestjs/common";
import { UserService } from "./user.service";
import { User } from "./user.entity";

@Controller('users')
export class UserController{
    constructor(private readonly userService:UserService){}
    @Get()
    findAll(){
        return this.userService.findAll();
    }
    
    @Get(':id')
    findOne(@Param('id') id:number){
        return this.userService.findOne(id);
    }
    
    @Post()
    create(@Body() user:User){
        return this.userService.create(user);
    }
    
    @Put(':id')
    update(@Param('id') id:number, @Body() user:User){
        return this.userService.update(id, user);
    }
    
    @Delete(':id')
    remove(@Param('id') id:number){
        return this.userService.remove(id);
    }
    

}